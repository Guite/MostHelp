# Troubleshooting

## Introduction

This sections collects information snippets which may be helpful when running into problems.

## Tooling problems

### I can't save my model

If you get an error message when trying to save your model this means that it is not possible to serialise the object graph you have currently opened in the memory. The probable reason for this is that there exists a reference to an element without a name. Therefore the serialiser sees no way to persist this reference.

For example if you have two entities and a relationship between them then all both entities need a name. Otherwise the relationship can not store it's source or target references.

To fix this just ensure that all existing elements have a name. Since ModuleStudio version 0.7.0 this is actively supported by setting sensitive default values when adding new elements.

## Generation problems

### Orphan removal with many-to-many relations

If you are generating for Zikula 1.3.x please do not enable the *orphanRemoval* property for many-to-many relationships. This feature is supported only in newer versions of Doctrine 2, therefore you need to use the *1.4* target if you want to use it.

### The workflows are not fetched properly

Due to a problem in Zikula 1.4.0 the workflow data can not be fetched automatically for an entity yet. Because if the `postLoad` listener in the `EntityLifecycleListener` class calls the workflow the Zikula `WorkflowUtil` class does another selection for this. This leads to both selections getting into a competition about the internal object hydrator of Doctrine. The workflow selection "steals" it from the main selection. So after the first item, when it wants to fetch the second one, it is not possible anymore. In 1.3.x this was not a problem because workflows were called using DBUtil bridged by Doctrine 1.

A clean solution would not use any workflow util class, but join the workflow entity directly (see [core ticket #2423](https://github.com/zikula/core/issues/2423) for more information). But this affects too many parts to do it quickly. Also to make it really beautiful we would need own workflow tables for each entity (like done with categories for example) in order to keep things together.

Before the `initWorkflow()` method was called at two places: the entity constructor (for newly-created entities) and the `postLoad` listener (for fetched entities). Note the Doctrine 2 development is working on a new event which is triggered after all entities have been fetched.

The current workaround is having the `initWorkflow()` call moved outside the `postLoad` listener. But now we have to call it elsewhere. Therefore we need something in the controller actions like the following for bypassing the problem:

    // single entity
    $myEntity->initWorkflow();

    // collection of entities
    foreach ($entities as $k => $entity) {
        $entity->initWorkflow();
    }

Note you must call this for all fetched entities, not for new ones (as the call is still included in the constructor).

This solution approach is a bit ugly, because we require you (the mod dev) calling this explicitly from the using code. If you forget it in a certain method workflows are not initialised properly. Of course this will be improved again as soon as Doctrine 2 offers the new event which happens really *post* fetch.

There is also a new [workflow component](http://symfony.com/blog/new-in-symfony-3-2-workflow-component) offered since Symfony 3.2. We are probably going to incorporate this into Zikula (see [core ticket #2423](https://github.com/zikula/core/issues/2423)) which might solve this issue, too.

### Earlier Zikula 1.3.x versions

#### Unable to find workflow file

If you get this error you have generated an application for Zikula 1.3.x which contains a small bug that is fixed in 1.3.7 and above.
Please apply the fix shown in [https://github.com/zikula/core/commit/f7e3379e7060859aab334be6707fe6e0ab61baf8](https://github.com/zikula/core/commit/f7e3379e7060859aab334be6707fe6e0ab61baf8) in order to fix the error.

#### Patch for category selector

Due to a bug in the category selector in Zikula 1.3.5 and 1.3.6 (solved in 1.3.7 and above) you will run into problems when trying to save an entity with categories. To solve this just merge the fix shown in [https://github.com/zikula/core/pull/1561/files](https://github.com/zikula/core/pull/1561/files) and you are done.
