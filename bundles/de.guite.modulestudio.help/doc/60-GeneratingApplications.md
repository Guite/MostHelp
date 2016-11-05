# Generating applications

The main use case for ModuleStudio application models is the creation of Zikula extensions. This section describes how the generator works.

## Basic idea

Every application consists of different types of code parts. While some code is unique for each application, most parts can be derived from that and is therefore very similar for a whole software systems family. Those code parts are known as *boilerplate code*.

A very simple example will make this clear very quickly:

    /**
     * imagine some long comments about this class here
     * @ORM\Entity ...
     * some more annotations
     */
    class Person
    {
        /**
         * imagine some long comments about this field here
         * @ORM\Column ...
         * some more annotations
         */
        protected $firstName;

        /**
         * imagine some long comments about this field here
         * @ORM\Column ...
         * some more annotations
         */
        protected $lastName;
    }

This code has obviously not very much knowledge which is essential for this certain application. Reduced to what is really required from a functional view one would get something like:

    entity person {
        string firstName
        string lastName
    }

Thought a little further the generator helps reaching a constantly high code quality, as all implementation details are always considered completely. For example if a new extension is activated for an entity this is not forgotten anywhere inside the code.

## How it works

Calling the generator within ModuleStudio is very easy. The only requirement is that you have an opened project and your application model does not contain any [validation errors](50-Validation.md#validation).

If there are no validation errors, choose the menu entry *File > Generate application* to call the generator. If the model contains unsaved changes or errors, error messages appear accordingly. If there are still warnings a dialog asks if these should be ignored. Once past any errors or warnings, you need to choose an output directory. Since the generator deletes everything in the specified directory, ensure to create a new empty folder. If you would choose a folder that was not empty, a dialog with a corresponding warning appears to allow you to confirm the selection. Afterwards click on OK to start the process. A progress dialog shows what the generator is currently creating. Finally a message notification shows that the generation is complete.

## The generation workflow

The rough steps of the generator workflow are as follows:

1. Ask for input parameters (in particular the desired output folder).
2. Empty output directory.
3. Export dumps of editor diagrams.
4. Read input model.
5. Perform validation.
6. Execute a model-to-model transformation. This adds primary and foreign key fields as well as other derived elements.
7. Call the actual generator workflow.

## From model to generated artifacts

The mapping from your model elements to the generated application elements is described in detail in the [generator reference](87-GeneratorReference.md#generator-reference) chapter.
