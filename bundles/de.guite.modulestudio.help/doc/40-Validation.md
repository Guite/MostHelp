# Validation

This chapter explains the intention behind validation in ModuleStudio. The biggest part is a reference section listing all validation rules in detail and explains the motivation behind them. You can use this reference to search for certain error messages if you want to know more about the background. If you are unsure about the terminology used in a description please refer to the [generator chapter](50-Generator.md#generator) in this documentation.

## Introduction

Validation is an essential part of a modeling language. By checking the current model against several *constraints* it ensures that certain scenarios can not happen in order to avoid problems based on invalid states of model elements.

With the help of validation in ModuleStudio all subsequent components can process the given application model without having to revalidate common concerns.

Having clean and properly validated models is also very helpful for Zikula as a framework because in the long term this leads to a constantly high quality across third party extensions which is traditionally a weak point for every open source system. See [this tutorial](http://modulestudio.de/en/tutorial/validation-instead-of-certification-of-3rd-party-framework-modules.html) for more information about this aspect.

The constraints described here are evaluated within the graphical editor as well as during headless generator workflows.

## Basic usage

This section gives a brief overview of how validation can be executed and what can be done if problems occur.

### Triggering validation

As validation shows what remains to be done in order to generate an application out of a given model, it is essential to provide convenient means for checking validation constraints.

ModuleStudio validates a model every time you save it in the main editor. Validation is also executed after an existing model has been opened.

In addition you can always start the validator manually using the main menu which might be advantageous to get immediate feedback after having done some amendments in the sub editors.

Earlier versions of ModuleStudio used to perform a scheduled validation. This has been removed to save performance.

### Validation consequences

As the generator requires a model without validation problems it can only be started in the main menu after your model has no errors left.

If the menu entry for starting the generator is inactive even if your models seems to be clean, please save the model in the main editor and click once in the diagram canvas to let the validation update it's state accordingly.

In case live validation has been deactivated you can start a *manual validation* in the main menu, too.

## Application layer

### Global rules

* The name must be a valid identifier (e.g. no whitespace or special characters). Mixed case is recommended to get more readable messages generated, for example *mySpecialUser*.

### Application

* The application must have a name. Application name must have a length of at least five chars.
* Application name must start with a capital letter. Since Zikula 1.3 extensions must start with a capital letter. Of course we could simply generate it this way. But for consistency we decided to follow this rule more strictly by enforcing it in the model already.
* The application must have an author.
* The application must have an email address.
* The value for the application email field must be a valid email address.
* The value for the application url field must be a valid url. Protocols allowed per default are *http* and *https*.
* The application must have a prefix for it's database tables. This prefix is required to prevent naming collisions between several modules. Otherwise it would be a problem if multiple extensions use common table names like *user* or *category*. The prefix must have a length of more than two chars, whereby a at least four is recommended.
* The prefix must be a valid identifier (e.g. no whitespace or special characters). Essentially the same as the global rule for names above. You should use lowercase here, but it will be generated in lowercase in all cases.
* The application must have a version. The application version must conform to the pattern `x.y.z`. Another requirement introduced in Zikula 1.3. Valid values are *1.0.0*, *1.2.2*, but not *1.1* or *2.1.0beta*.
* The application must contain at least one entity. At the moment ModuleStudio wants a model with at least one entity. If you are modeling an extension without any data storage, just create some dummy elements.
* The application must contain at least one controller. ModuleStudio requires at least one controller, because otherwise the module wouldn't do anything. If you are modeling an extension without any controllers, just create some dummy elements.
* The application may contain only one settings container.

### Settings container

* The core version target is deprecated and going to be removed soon. This warning appears if you change the target core version to 1.3.x to `ZK135` or `ZK136`. Those are going to be removed in a later version.
* Settings container must be assigned to an application. Should not occur in practice, this is just for completeness.
* Scribite plugins require external controller and finder component. If you enable `generateScribitePlugins` you also need `generateExternalControllerAndFinder`.

### Referred application

* The imported application must have a name. Use the real name of the module being imported.
* Please specify the minimum version for the dependency. The minimum version must conform to the pattern `x.y.z`.
* Please specify the maximum version for the dependency. The maximum version must conform to the pattern `x.y.z`.
* The minimum version must not be greater than the maximum version.
* You need to specify the URI of the imported application's model file.

## Model layer

### Data object

* The data object must be assigned to an application. Should not occur in practice, this is just for completeness.
* Every data object must contain at least one field or inherit fields from a parent object. Ensures that either there are some fields in this entity or an outgoing inheritance relationship.
* You may not mark a field as primary, this is done automatically - unless maybe you want to create composite primary keys. This warning appears because ModuleStudio adds primary keys automatically and uses the Doctrine 2 default settings if nothing else is explicitly specified in the model. Beside special use cases like custom join conditions or composite primary keys you won't need to set primary keys manually.
* Remove ID fields... you do not need them ;-) unless maybe you want to create composite primary keys. This warning appears if a field is named like `id` or `personid` or `person_id` for a data object named `person`. By default ModuleStudio adds primary keys automatically before generation happens.
* Data object names must be unique. For example there must not exist two entities which are both named `person`.
* Every entity must have a (name | name for multiple instances). Entity (multiple) name must have a length of at least two chars. Should have at least four chars.
* Entity (multiple) name must not contain underscores. Underscores are not allowed as they are used for class autoloading.
* Data object name must not be `config`. The generator creates a dedicated config controller for handling configuration pages.
* The amount of data objects is getting quite high. Maybe it makes sense to split up the model into two single applications. This warning appears if you have more than 14 data objects. Remember Zikula is a modular system. You can design whole families of extensions with ModuleStudio, so please try keeping complexity low and apply the principle *separation of concerns*.
* A data object must not have the same name as the application. This case is reserved as it could make sense to use corresponding namespaces in generation for encapsulating some common code parts.

### Entity

#### General entity settings

* Exactly one entity must be declared as leading (`leading=true`).
* Composite entities can only have identifier strategy `NONE`. Automatic identifier generation is not possible for composite primary keys.
* The entity needs a display pattern. Occurs when no display pattern is defined.
* The display pattern does not contain any field references. Please check whether this is on purpose or not. This warning occurs if a display pattern does not contain any field references.
* Every entity with an archive (`hasArchive` set to `true`) must contain one datetime or date field designated as end date. For implementation of an automatic archiving functionality the system must know when an object has reached the end of it's lifecycle.
* The length of all entity fields must not be higher than `21845`. The limit is `65535` bytes, while UTF-8 requires three bytes for each char.

#### Inheritance-related entity settings

* All entities within a class hierarchy must have the same change tracking policy. Requirement by Doctrine 2.
* All entities within a class hierarchy must not have a field with the same name.
* All associations outgoing from mapped super classes must be unidirectional.
* One-to-many relations are not possible for mapped super classes.
* Many-to-many relations are only possible for mapped super classes if it is used only in one entity at the same time.

#### Extension-related entity settings

* Entities with owner permissions need standard fields activated. The standard fields extension is required to determine the owner (`createdUser`) of an object.
* Loggable entities need one field with the version attribute set to `true`. Can be either integer or datetime fields.
* Entities with geographical behaviour should ideally contain a String Field with name zipcode with a length of at least 10. Just a warning to support best practices.
* There must not exist an entity named `FooLogEntry` as this is reserved by the corresponding extension. For an entity named *person* with `loggable = true` ModuleStudio generates an additional entity named `PersonLogEntry` for managing the it's version log entries.
* There must not exist an entity named `FooTranslation` as this is reserved by the corresponding extension. For an entity named *person* with translatable fields ModuleStudio generates an additional entity named `PersonTranslatable` for managing it's translations.
* There must not exist an entity named `FooClosure` as this is reserved by the corresponding extension. For an entity named *person* with a closure tree ModuleStudio generates an additional entity named `PersonClosure` for managing it's closures. For nested sets this additional entity is not required.
* There must not exist an entity named `FooAttribute` as this is reserved by the corresponding extension. For an entity named *person* with `attributable = true` ModuleStudio generates an additional entity named `PersonAttribute` for managing it's attributes.
* There must not exist an entity named `FooCategory` as this is reserved by the corresponding extension. For an entity named *person* with `categorisable = true` ModuleStudio generates an additional entity named `PersonCategory` for managing it's categories.
* There must not exist an entity named `FooMetaData` as this is reserved by the corresponding extension. For an entity named *person* with `meta data = true` ModuleStudio generates an additional entity named `PersonMetaData` for managing it's meta data.

### Entity field

#### General field settings

* Field must be assigned to a data object. Should not occur in practice, this is just for completeness.
* Every field must have a name. Field name must have a length of at least two chars. Should have more than three chars.
* Field names must be unique. 
* Field name is a reserved identifier (`module`, `type`, `func`, `lang`, `theme`). These are reserved vars in traditional Zikula extensions.
* Field name is a reserved identifier (`_controller`, `_method`, `_locale`). These are reserved vars in the Symfony framework.
* Field name is a reserved identifier (`workflowState`). This list field is added automatically by a model-to-model transformation before the actual generation happens.
* Field name is a reserved database keyword. ModuleStudio prevents the usage of keywords which are reserved in some database systems. Background is that there are no column prefixes anymore. For a list of all keywords see [the following section](#reserved-database-keywords).
* Mandatory fields may not be nullable, too. Occurs if you try to activate both `mandatory` and `nullable` properties for a field.
* The default value is too long for the specified field length.
* The minimum value is too long for the specified field length.
* The maximum value is too long for the specified field length.
* Fields using text or blob data types must not be unique (applies for text, array and object fields).
  
Note all rules for name validation are applied not only to `name`, but also to the `dbName` property, too, if it is set for a certain field.

##### Reserved database keywords

The following list has been merged and includes therefore all keywords of all supported DBMS.

* abort, access, action, activate, add, after, alias, all, allocate, allow, alter, analyse, analyze, and, any, arraylen, as, asc, asensitive, associate, asutime, at, attach, attributes, audit, authorization, autoincrement, aux, auxiliary, avg
* backup, before, begin, between, bigint, binary, blob, both, break, browse, bufferpool, bulk, by
* cache, call, called, capture, cardinality, cascade, cascaded, case, cast, ccsid, change, char, character, check, checkpoint, clone, close, cluster, clustered, coalesce, collate, collection, collid, column, comment, commit, committed, compress, compute, concat, condition, conflict, connect, connection, confirm, constraint, contains, containstable, continue, controlrow, convert, count, count_big, create, cross, current, current_date, current_lc_ctype, current_path, current_schema, current_server, current_time, current_timestamp, current_timezone, current_user, cursor, cycle
* data, database, databases, datapartitionname, datapartitionnum, date, day, days, day_hour, day_microsecond, day_minute, day_second, db2general, db2genrl, db2sql, dbcc, dbinfo, dbpartitionname, dbpartitionnum, deallocate, dec, decimal, declare, default, defaults, deferrable, deferred, definition, delayed, delete, dense_rank, denserank, deny, desc, describe, descriptor, detach, deterministic, diagnostics, disable, disallow, disconnect, disk, distinct, distinctrow, div, distributed, do, document, double, drop, dssize, dummy, dual, dynamic
* each, editproc, else, elseif, enable, encoding, encryption, end, enclosed, end-exec, ending, erase, errlvl, errorexit, escape, escaped, every, except, exception, excluding, exclusive, exec, execute, exists, exit, explain, external, extract
* fail, false, fenced, fetch, fieldproc, file, final, fillfactor, float, float4, float8, floppy, for, force, foreign, free, freetext, freetexttable, freeze, from, full, fulltext, function
* general, generated, get, glob, global, go, goto, grant, graphic, group
* having, handler, hash, hashed_value, having, high_priority, hint, hold, holdlock, hour, hours, hour_microsecond, hour_minute, hour_second
* identified, identity, identitycol, identity_insert, if, ignore, ilike, immediate, in, including, inclusive, increment, index, indexed, indicator, inf, infile, infinity, inherit, initial, initially, inner, inout, insensitive, insert, instead, int, int1, int2, int3, int4, int8, integer, integrity, intersect, interval, into, is, isnull, isobid, isolation, iterate
* jar, java, join
* keep, key, keys, kill
* label, language, lateral, lc_ctype, leading, leave, left, level, like, limit, lineno, lines, linktype, load, local, localdate, locale, localtime, localtimestamp, locator, locators, lock, lockmax, locksize, long, longblob, longtext, loop, low_priority
* maintained, match, materialized, max, maxextents, maxvalue, mediumblob, mediumint, mediumtext, microsecond, microseconds, middleint, min, minus, minute, minutes, minute_microsecond, minute_second, minvalue, mirrorexit, mod, mode, modifies, modify, month, months
* nan, national, natural, new, new_table, nextval, no, noaudit, nocache, nocheck, nocompress, nocycle, nodename, nodenumber, nomaxvalue, nominvalue, nonclustered, none, noorder, normalized, not, notfound, notnull, nowait, no_write_to_binlog, null, nullif, nulls, number, numeric, numparts
* obid, of, off, offline, offset, offsets, old, old_table, on, once, online, only, open, opendatasource, openquery, openrowset, optimization, optimize, option, optionally, or, order, out, outer, outfile, over, overlaps, overriding
* package, padded, pagesize, parameter, part, partition, partitioned, partitioning, partitions, password, path, pctfree, percent, perm, permanent, piecesize, placing, pipe, plan, pragma, position, precision, prepare, prevval, primary, print, prior, priqty, privileges, proc, procedure, processexit, program, psid, public, purge
* query, queryno
* raid0, raise, raiserror, range, rank, raw, read, reads, readtext, real, reconfigure, recovery, references, referencing, refresh, regexp, reindex, release, rename, repeat, repeatable, replace, replication, require, reset, resignal, resource, restart, restore, restrict, result, result_set_locator, return, returns, revoke, right, rlike, role, rollback, round_ceiling, round_down, round_floor, round_half_down, round_half_even, round_half_up, round_up, routine, row, rowcount, rowguidcol, rowid, rowlabel, rownum, rownumber, rows, rowset, row_number, rrn, rule, run
* save, savepoint, schema, schemas, scratchpad, scroll, search, second, seconds, second_microsecond, secqty, security, select, sensitive, separator, sequence, serializable, session, session_user, set, setuser, share, show, shutdown, signal, similar, simple, size, smallint, snan, some, soname, source, spatial, specific, sql, sqlbuf, sqlexception, sqlid, sqlstate, sqlwarning, sql_big_result, sql_calc_found_rows, sql_small_result, ssl, stacked, standard, start, starting, statement, static, statistics, statment, stay, stogroup, stores, straight_join, style, substring, successful, sum, summary, synonym, sysdate, sysfun, sysibm, sysproc, system, system_user
* table, tablespace, tape, temp, temporary, terminated, textsize, then, time, timestamp, tinyblob, tinyint, tinytext, to, top, trailing, tran, transaction, trigger, trim, true, truncate, tsequal, type
* uid, uncommitted, undo, union, unique, unlock, unsigned, until, update, updatetext, usage, use, user, using, utc_date, utc_time, utc_timestamp
* vacuum, validate, validproc, value, values, varbinary, varchar, varchar2, varcharacter, variable, variant, varying, vcat, verbose, version, view, virtual, volatile, volumes
* waitfor, when, whenever, where, while, with, without, write, writetext, work
* x509, xmlelement, xmlexists, xmlnamespaces, xor
* year, years, year_month
* zerofill

#### Extension-related field settings

* Entities with sluggable behaviour may not include a field named slug. If a field is named `slug` it gets this error as soon as at least one field in this entity has set the `sluggable position` attribute to a number greater than `0`. ModuleStudio creates this slug field automatically in addition to the other fields in the model.
* The sluggable position values must be unique per entity. If fields are included into a slug by setting a value greater than `0`, this value must be unique per entity. The position defines in which order the field values are considered as permalink parts.
* Only one field per entity may store the sortable position. Can occur if one tries to use multiple integer or user fields as position for the sortable extension.
* The sortable position may not be the sortable group, too. As soon as a field is used as sortable position it can not also act as the grouping criteria at the same time.
* You need another field as sortable position to make the sortable group work. Can occur for a field marked as sortable group.
* Only one field per entity may store the version. Can appear for integer and datetime fields if you enabled the `version` property for more than one field in the same entity.
* Only one field per entity may represent a start date. Can appear for datetime and date fields if you enabled the `start date` property for more than one field in the same entity.
* Only one field per entity may represent an end date. Can appear for datetime and date fields if you enabled the `end date` property for more than one field in the same entity.
* Entities with a version field should use optimistic locking. Can appear for integer and datetime fields with the `version` property enabled. You must set the locking type of the corresponding entity to either `OPTIMISTIC` or `PAGELOCK_OPTIMISTIC`, depending on whether you want support the Zikula PageLock functionality in addition or not.
* Entities with optimistic locking must contain a field declared as version field. The opposite rule to ensure that every entity using optimistic locking has a version field for storing and comparison the version as locking criteria.
* The version attribute can not be combined with a primary key. A field can only act as either a version or a primary key, not both at the same time.
* Entities with geographical extension have additional fields names (`longitude`, `latitude`). Thus your (fields may not contain these names | reference may not contain these (source | target) aliases). If an entity has activated the `geographical` extension ModuleStudio creates coordinate fields automatically in addition to the other fields in the model (as well as some usage of geolocation when creating new entities).
* Entities with translatable fields have an additional field for the language code (`locale`). Thus your (fields may not contain this name | reference may not contain this (source | target) alias). If at least one entity field has activated the `translatable` extension ModuleStudio creates a field named `locale` automatically in addition to the other fields in the model.
* Entities with tree extension have additional fields names (`lft`, `lvl`, `rgt`, `root`, `parent`, `children`). Thus your (fields may not contain these names | reference may not contain these (source | target) aliases). If an entity has activated the `tree` extension ModuleStudio creates these fields automatically in addition to the other fields in the model (as well as a convenient hierarchy management page). This does apply on both tree strategies (`nested set` as well as `closure`).
* Entities with attributes have an additional field for referencing these (`attributes`). Thus your (fields may not contain this name | reference may not contain this (source | target) alias). If an entity has activated the `attributable` extension ModuleStudio creates an additional relation to store the collection of attributes for a certain entity.
* Entities with categories have an additional field for referencing these (`categories`). Thus your (fields may not contain this name | reference may not contain this (source | target) alias). If an entity has activated the `categorisable` extension ModuleStudio creates an additional relation to store the collection of categories for a certain entity.
* Entities with meta data have an additional field for referencing these (`metaData`). Thus your (fields may not contain this name | reference may not contain this (source | target) alias). If an entity has activated the `meta data` extension ModuleStudio creates an additional relation to store the meta data for a certain entity.
* Entities with enhanced workflows need standard fields for creator identification. If you enabled another workflow than `NONE` you may not disable the `standard fields` extension because the creator is used for sending notifications to the moderators.
* Entities with Zikula standard fields extension have an additional additional fields (`createdDate`, `createdUserId`, `updatedDate`, `updatedUserId`). Thus your (fields may not contain these names | reference may not contain these (source | target) aliases). If an entity has activated the `standard fields` extension ModuleStudio creates some additional fields to store these for a certain entity.

#### Numeric fields

* The default value for an integer field must contain only digits.
* The maximum length for an integer field is `18`. Corresponds to a `bigint` mapping in Doctrine 2.
* Minimum value must not be larger than maximum value.
* An integer field must not act as percentage and range at the same time.
* Entities with an aggregate field should use a locking strategy (optimistic or pessimistic read). If an integer field acts as aggregate field the corresponding entity must use one locking strategy of `OPTIMISTIC`, `PAGELOCK_OPTIMISTIC`, `PESSIMISTIC_READ` or `PAGELOCK_PESSIMISTIC_READ`, depending on whether you want support the Zikula PageLock functionality in addition or not.
* Aggregate fields work only in combination with an outgoing and bidirectional one-to-many relationship with persist cascade.
* Naming of aggregateFor attribute values must follow the syntax `targetAlias#targetFieldName` (for example `views#amount`). If an integer field acts as aggregate field the property `aggregate for` must define the target alias of corresponding outgoing and bidirectional one-to-many relationship with persist cascade. After a `#` char as delimiter the name of the target field (to be aggregated) follows.
* The default value for a decimal field must be a floating point number.
* The length (precision) of a decimal field must be greater than the scale. For example `1234.12` is valid (4 > 2), but `123.1234` is not.
* Minimum value must not be larger than maximum value.
* A decimal field must not act as `percentage` and `currency` at the same time.
* The default value for a float field must be a floating point number.
* Minimum value must not be larger than maximum value.
* A float field must not act as `percentage` and `currency` at the same time.

#### String and text fields

* String size must not be smaller than `1`. Occurs if length is set to `0`.
* String size must be larger than minimum length. If you set a minimum length it must not be larger than the actual field length.
* String length for bic numbers must be at least `12` chars. Occurs if you activate the `bic` property for a field with a length smaller than `12`.
* String length for credit card numbers must be at least `20` chars. Occurs if you activate the `credit card` property for a field with a length smaller than `20`.
* String length for country codes must be at least `2` chars. Occurs if you activate the `country` property for a field with a length smaller than `2`.
* String length for currency codes must be at least `3` chars. Occurs if you activate the `currency` property for a field with a length smaller than `3`.
* String length for iban numbers must be at least `34` chars. Occurs if you activate the `iban` property for a field with a length smaller than `34`.
* String length for languages must be at least `7` chars. Occurs if you activate the `language` property for a field with a length smaller than `7`.
* String length for locales must be at least `5` chars. Occurs if you activate the `locale` property for a field with a length smaller than `5`.
* String length for HTML colour codes must be at least `7` chars. Occurs if you activate the `html colour` property for a field with a length smaller than `7`.
* String length for ip addresses must be at least `15` chars. Occurs if you set the `ip address` property to a value covering IPv4 addresses for a field with a length smaller than `15`.
* String length for ip addresses must be at least `39` chars. Occurs if you set the `ip address` property to a value covering IPv6 addresses for a field with a length smaller than `39`.
* String length for time zones must be at least `30` chars. Occurs if you activate the `timezone` property for a field with a length smaller than `30`.
* String length for uuids must be at least `36` chars. Occurs if you activate the `uuid` property for a field with a length smaller than `36`.
* A string can only be one of bic, country, creditCard, currency, language, locale, htmlcolour, iban, isbn, issn, ip address, password, timezone and uuid.
* String fields for bic, countries, currencies, languages, locales, ip addresses, colours and uuids must also activate the nospace validator. The `nospace` property ensures that spaces are not allowed as part of the input value. The generator could use it without having set this to true, but as the setting is there anyway the proper solution is to enforce the user activating it for consistency.
* String length must not be greater than `255`; for bigger sizes use text fields.
* The default value for an email field must be a valid email address.
 
* The default value for an url field must be a valid url. Allowed protocols are `http`, `ftp` and `https`.

#### Date and time fields

This section includes rules which apply only for datetime, date and time fields.

* A value can not be in the past and in the future at the same time. You can only activate either `past` or `future` validators for one field.
* A value can not represent both start and end date at the same time. You can only activate either `start date` or `end date` flags for one field.
* The timestampable change trigger field must point to `workflowState`, the name of a field or a relation (property.field). If the `timestampable` property for a field has been set to `CHANGE` then this error can appear to remind you to set also the required attribute `timestampable change trigger field`. Either you did not set anything there or the value does neither correspond to `workflowState` nor the name of an entity field nor an incoming relation.
* It would be preferable to use an integer column as version field, as datetimes could potentially lead to conflicts for high traffic sites depending on the timestamp resulution in the database. If you use datetime fields with `version = true` this warning will appear. As the Doctrine 2 manual points out integers are more robust against race conditions in high traffic environments where timestamp comparisons are limited due to how precise the used database does it. Therefore you should prefer integer fields for storing versions except side conditions require the usage of datetime fields for that.
* The default value for a datetime field must conform to the pattern `YYYY-MM-DD HH:MM:SS` or `now`. You can either set a certain value or use `now` to specify the current timestamp.
* The default value for a date field must conform to the pattern `YYYY-MM-DD` or `now`. You can either set a certain value or use `now` to specify today.
* The default value for a time field must conform to the pattern `HH:MM:SS` or `now`. You can either set a certain value or use `now` to specify the current moment.

#### Upload fields

* The `allowed extensions` attribute must contain a comma separated list of the file types to be allowed during the upload (example: `gif, jpeg, jpg, png`). Note that the separator is `', '` including the space char.
* The `allowedFileSize` attribute must not have a value lower than 0.
* The `allowedFileSize` attribute is deprecated and will be removed in a future version. Please use `maxSize` instead.
* There must not exist a field named `fooMeta` because this is reserved for an automatic field storing meta data for this upload.
* Minimum image width must not be larger than maximum image width.
* Minimum image height must not be larger than maximum image height.
* Minimum image aspect ratio must not be larger than maximum image aspect ratio.
* Either square or landscape or portrait images must be allowed.

#### List fields

* The list must contain at least one item.
* The list must contain at least two items. Occurs if you enable `multiple` without having defined multiple list items.
* The list is not set to multiple and may therefore only contain one item with `default` property set to `true`.
* Only lists with multiple selections can define an enforced minimum (maximum) amount of selected values. Occurs if you set `min` (`max`) to a value not equal to `0`, without having set `multiple = true`.
* The amount of list items must not be smaller than the minimum (maximum) amount of enforced values. Occurs if you set `min` (`max`) to a value which is greater than the actual number of existing list items.
* The maximum amount of enforced values must not be smaller than the minimum amount of enforced values. Occurs if you set `max` to a smaller value than `min`.

#### Array fields

* Enforcing a certain amount of items requires setting both `min` and `max` properties. Occurs if you set either `min` or `max` to a value greater than `0`, but not both.
* The maximum amount of enforced items must not be smaller than the minimum amount of enforced items. Occurs if you set `max` to a smaller value than `min`.

### Relationship

* Relation must be assigned to an application. Should not occur in practice, this is just for completeness.
* Every relation must have a (source | target) data object. Should not occur in practice, this is just for completeness.

#### Join relationship

Includes basically all relationships in the data layer except inheritance.

* Every join relation must have a (source | target) alias. Aliases must have a length of at least two chars. Recommended are at least four chars.
* Relationship source aliases must be unique for all incoming relations of an entity.
* Relationship source aliases must not be named like a field of the target entity.
* Relationship target aliases must be unique for all outgoing relations of an entity.
* Relationship target aliases must not be named like a field of the source entity.
* The (`sourceField` | `targetField`) attribute must contain either `id` for automatic primary key or a comma separated list of (source | target) fields to be referenced. Note that the separator is `', '` including the space char.
* The amount of join columns must be equal for association source and target sides. If source or target field are not `id` ModuleStudio splits both values by the separator above and compares the amount of elements on both sides. This enables joins over multiple fields.
* The field `sourceField` | `targetField` must be an integer field with a length of `11`. Is only checked if the (source | target) field is named `id`.
* The fields `sourceField` and `targetField` must have the same type and length values. Is only checked if the source and target fields are both not named `id`.
* Self relation must not reference the `sourceField` field for both source and target. For self relation the source field must not be equal to the target field (as the database needs two fields in order to store both sides).
* Between two entities there must not be multiple join relations with cascade options.

#### One to one relationship

* The edit type `ACTIVE_CHOOSE_PASSIVE_NONE` is only valid for many to many relationships.
* The edit type `ACTIVE_EDIT_PASSIVE_NONE` is only valid for many to many relationships.
* Entities with soft-deleteable need a remove cascade for any incoming one-to-one relationships. See [this issue](https://github.com/Atlantic18/DoctrineExtensions/issues/936) for more information.

#### Many to one relationship

* The edit type `ACTIVE_CHOOSE_PASSIVE_NONE` is only valid for many to many relationships.
* The edit type `ACTIVE_EDIT_PASSIVE_NONE` is only valid for many to many relationships.
* A many-to-one relation must not be bidirectional.

#### One to many relationship

* The edit type `ACTIVE_CHOOSE_PASSIVE_NONE` is only valid for many to many relationships.
* The edit type `ACTIVE_EDIT_PASSIVE_NONE` is only valid for many to many relationships.
* The `orderBy` attribute points to an invalid field of the target entity. Checks whether the target entity contains a field equally named like the `orderBy` property.
* The `indexBy` attribute points to an invalid field of the target entity. Checks whether the target entity contains a field equally named like the `indexBy` property.
* IndexBy fields must be unique. The target entity field used for `indexBy` must have the `unique` validator enabled.
* Enforcing a certain amount of items on the target side requires setting both `minTarget` and `maxTarget` properties. Occurs if you set either `minTarget` or `maxTarget` to a value greater than `0`, but not both.
* The maximum amount of enforced items on the target side must not be smaller than the minimum amount of enforced items. Occurs if you set `maxTarget` to a smaller value than `minTarget`.

#### Many to many relationship

* The `orderBy` attribute points to an invalid field of the (source | target) entity. Checks whether the (source | target) entity contains a field equally named like the `orderBy` | `orderByReverse` property.
* The `indexBy` attribute points to an invalid field of the target entity. Checks whether the target entity contains a field equally named like the `indexBy` property.
* IndexBy fields must be unique. The target entity field used for `indexBy` must have the `unique` validator enabled.
* A many-to-many relation must have the `refClass` attribute defined. The `reference class` defines the name of the entity managing the many to many relationship. If for example many *persons* have many *addresses*, you could choose `personAddress` as reference class.
* The `refClass` attribute must be unique for all relations.
* The `refClass` attribute must not be equal to any entity name. The generator creates additional entity classes so unique naming is ensured to prevent naming collisions.
* Enforcing a certain amount of items on the source side requires setting both `minSource` and `maxSource` properties. Occurs if you set either `minSource` or `maxSource` to a value greater than `0`, but not both.
* The maximum amount of enforced items on the source side must not be smaller than the minimum amount of enforced items. Occurs if you set `maxSource` to a smaller value than `minSource`.
* Enforcing a certain amount of items on the target side requires setting both `minTarget` and `maxTarget` properties. Occurs if you set either `minTarget` or `maxTarget` to a value greater than `0`, but not both.
* The maximum amount of enforced items on the target side must not be smaller than the minimum amount of enforced items. Occurs if you set `maxTarget` to a smaller value than `minTarget`.

#### Inheritance relationship

* Self relations are not allowed for inheritance relationships.
* The `discriminatorColumn` attribute must not be empty for inheritance relations. Per default this attribute has the value `discr` so this shouldn't happen as long as you don't delete this value. ModuleStudio uses this value to tell Doctrine 2 where to store the type of stored entities.
* Please rename the `discriminatorColumn` field as it is reserved for the discriminator column, or change corresponding attribute. Happens if the target entity includes a field with the same name as specified in the `discriminator` setting.
* Inheritance cycles are not allowed. Recursive check to detect cycles within inheritance hierarchies.
* All inheritance connections within a class hierarchy must have the same inheritance strategy.
* All inheritance connections within a class hierarchy must have the same discriminator column.
* An entity can not inherit from multiple entities.

### Entity index

* Index must be assigned to a data object. Should not occur in practice, this is just for completeness.
* Every index must have a name. The index name must have a length of at least two chars. Recommended are at least four chars.
* Every index must contain at least one item referencing an entity field.
* The length of all index fields must not be higher than `333`. The limit is `1000` bytes, while UTF-8 requires three bytes for each char.
* Index names must be unique per entity.
* Index item names must be unique per index.

#### Entity index item

* The index item must be assigned to an index. Should not occur in practice, this is just for completeness.
* Every index item must have the same name as the referenced entity field. This occurs if no equally named field is found in the entity.

### Variables

* It is recommended to add two integer variables named `pageSize` and `showOnlyOwnEntries` for controlling the view action's behaviour. Occurs if a model contains a view action, but no according variables are found.
* Every var container must have a name.
* Var container names must be unique.
* Var container sort positions must be unique.
* Every var container must contain at least one variable.
* Var container must be assigned to an application. Should not occur in practice, this is just for completeness.
* The var must be assigned to a container. Should not occur in practice, this is just for completeness.
* Every var must have a name. The var name must have a length of at least two chars. Recommended are at least four chars.
* A var must not have the same name as an entity.
* A list var must contain at least one item.

### Calculated field

* The field must rely on at least one derived field. Not relevant yet, this is for future.

## Controller layer

### Controller

* You must have an admin controller for hook subscriber functionality. Since Zikula 1.3 it is highly recommended to have an admin area as there is an additional page for defining hook assignments for different areas.
* Controller names must be unique. For example there may not be two controllers which are both named `admin`.
* Please create an ajax controller including an arbitrary action, like index, because it is required for processing your model properly. This happens if your model contains relationships or an entity with either user fields or tree extension. As the generator creates additonal ajax methods in these cases it requires an ajax controller for keeping this information also in the model for documentation.
* There must not exist more than one (`admin` | `user` | `ajax`) controller. Predefined controllers are unique per application (i.e. there is only one admin area).
* Names of custom controllers must be unique. For example there may not be two controllers which are both named `edit`.
* The controller must be assigned to an application. Should not occur in practice, this is just for completeness.
* Every controller must have a name. Controller name must have a length of at least three chars. Should be at least four chars.
* Controller name must not contain underscores. Underscores are not allowed as they are used for class autoloading.
* Controller name must not be `Admin`, `User`, `Account`, `Ajax` or `External`. These are reserved names and may therefore not be used for custom controllers.
* Every controller must contain at least one action.
* There must not exist any (`view` | `display` | `edit` | `delete`) action in a (`admin` | `user` | `custom`) controller. They are allowed for entities and ajax controllers though.
* There must not exist more than one index action in one controller.
* There must not exist more than one (`index` | `view` | `display` | `edit` | `delete`) action in one entity.
* Names of custom actions in one controller must be unique.
* An ajax controller may not contain a delete action. Please remove it. The delete action is not implemented (yet) for ajax controllers.

### Action

* The action must be assigned to a controller or to an entity. Should not occur in practice, this is just for completeness.

#### Custom action

* The action must have a name. Action name must not be `New` or `Hooks`. Must have a length of at least four chars, whereby at least six chars are recommended.
* Action name must not be `Index`, `View`, `Display`, `Edit` or `Delete`. These are reserved names and may therefore not be used for custom actions.

## Workflow layer

The workflow layer is not implemented yet (planned for version 0.8). This section is just a dummy for future.
