# Validation Reference

The biggest part is a reference section listing all validation rules in detail and explains the motivation behind them. You can use this reference to search for certain error messages if you want to know more about the background. If you are unsure about the terminology used in a description please refer to the [generator reference](87-GeneratorReference.md#generator-reference) in this documentation.

## Application layer

### Global rules

* The name must be a valid identifier (e.g. no whitespace or special characters). Camel case is recommended to get more readable messages generated, for example *mySpecialUser*.

### Application

* The application must have a name. Application name must have a length of at least five chars.
* Application name must start with a capital letter. Since Zikula extensions must start with a capital letter. Of course we could simply generate it this way. But for consistency we decided to follow this rule more strictly by enforcing it in the model already.
* The application must have an author.
* The application must have an email address.
* The value for the application email field must be a valid email address.
* The value for the application url field must be a valid url. Protocols allowed per default are *http* and *https*.
* The application must have a prefix for it's database tables. This prefix is required to prevent naming collisions between several bundles. Otherwise it would be a problem if multiple extensions use common table names like *user* or *category*. The prefix must have a length of more than two chars, whereby a at least four is recommended.
* The prefix must be a valid identifier (e.g. no whitespace or special characters). Essentially the same as the global rule for names above. You should use lowercase here, but it will be generated in lowercase in all cases.
* The application must have a version. The application version must conform to the pattern `x.y.z`. Valid values are *1.0.0*, *1.2.2*, but not *1.1* or *2.1.0beta*.
* The application must contain at least one entity. At the moment ModuleStudio wants a model with at least one entity. If you are modelling an extension without any data storage, just create some dummy elements.
* Item action position both must not be enabled for index actions.
* Item action icons flag must not be disabled if item action style is configured to use icons only.

### Referred application

* The imported application must have a name. Use the real name of the bundle being imported.
* Please specify the minimum version for the dependency. The minimum version must conform to the pattern `x.y.z`.
* Please specify the maximum version for the dependency. The maximum version must conform to the pattern `x.y.z`.
* The minimum version must not be greater than the maximum version.
* You need to specify the URI of the imported application's model file.

## Model layer

### Data object

* Every data object must contain at least one field or inherit fields from a parent object. Ensures that either there are some fields in this entity or an outgoing inheritance relationship.
* You may not mark a field as primary, this is done automatically. This warning appears because ModuleStudio adds primary keys automatically and uses the Doctrine 2 default settings if nothing else is explicitly specified in the model. Beside special use cases like custom join conditions or composite primary keys you won't need to set primary keys manually.
* Remove ID fields... you do not need them ;-) This warning appears if a field is named like `id` or `personid` or `person_id` for a data object named `person`. By default ModuleStudio adds primary keys automatically before generation happens.
* Data object names must be unique. For example there must not exist two entities which are both named `person`.
* Every entity must have a (name | name for multiple instances). Entity (multiple) name must have a length of at least two chars. Should have at least four chars.
* Entity (multiple) name must not contain underscores. Underscores are not allowed as they are used for class autoloading.
* The amount of data objects is getting quite high. Maybe it makes sense to split up the model into two single applications. This warning appears if you have more than 14 data objects. Remember Zikula is a modular system. You can design whole families of extensions with ModuleStudio, so please try keeping complexity low and apply the *separation of concerns* principle.
* A data object must not have the same name as the application. This case is reserved as it could make sense to use corresponding namespaces in generation for encapsulating some common code parts.

### Entity

#### General entity settings

* Exactly one entity must be declared as leading (`leading=true`).
* Composite keys are not supported anymore.
* The entity needs a display pattern. Occurs when no display pattern is defined.
* The display pattern does not contain any field references. Please check whether this is on purpose or not. This warning occurs if a display pattern does not contain any field references.
* Every entity with an archive (`hasArchive` set to `true`) must contain one datetime or date field designated as end date. For implementation of an automatic archiving functionality the system must know when an object has reached the end of it's lifecycle.
* Every entity with automatic deletion (`deleteExpired` set to `true`) must contain one datetime or date field designated as end date. For implementation of an automatic archiving functionality the system must know when an object has reached the end of it's lifecycle.
* An entity must not use concurrently both archiving and deletion. Occurs if both `hasArchive` and `deleteExpired` are set to `true`.
* The length of all entity fields must not be higher than `16383`. The limit is `65535` bytes, while UTF-8 requires four bytes for each char.

#### Inheritance-related entity settings

* All entities within a class hierarchy must have the same change tracking policy. Requirement by Doctrine 2.
* All associations outgoing from mapped super classes must be unidirectional.
* One-to-many relations are not possible for mapped super classes.
* Many-to-many relations are only possible for mapped super classes if it is used only in one entity at the same time.

#### Extension-related entity settings

* Entities with owner permissions need standard fields activated. The standard fields extension is required to determine the owner (`createdBy`) of an object.
* Loggable entities need an integer field with the `version` attribute set to `true`.
* Entities with geographical behaviour should ideally contain a String field with name zipcode with a length of at least 10. Just a warning to support best practices.
* There must not exist an entity named `FooLogEntry` as this is reserved by the corresponding extension. For an entity named *person* with `loggable = true` ModuleStudio generates an additional entity named `PersonLogEntry` for managing the it's version log entries.
* There must not exist an entity named `FooTranslation` as this is reserved by the corresponding extension. For an entity named *person* with translatable fields ModuleStudio generates an additional entity named `PersonTranslatable` for managing it's translations.
* There must not exist an entity named `FooClosure` as this is reserved by the corresponding extension. For an entity named *person* with a closure tree ModuleStudio generates an additional entity named `PersonClosure` for managing it's closures. For nested sets this additional entity is not required.
* There must not exist an entity named `FooCategory` as this is reserved by the corresponding extension. For an entity named *person* with `categorisable = true` ModuleStudio generates an additional entity named `PersonCategory` for managing it's categories.

### Field

#### General field settings

* Every field must have a name. Field name must have a length of at least two chars. Should have more than three chars.
* Field names must be unique.
* Field name is a reserved identifier (`ajax`, `theme`). These names are reserved.
* Field name is a reserved identifier (`_controller`, `_method`, `_locale`). These are reserved vars in the Symfony framework.
* Field name is a reserved identifier (`workflowState`). This list field is added automatically by a model-to-model transformation before the actual generation happens.
* Field name is a reserved database keyword. ModuleStudio prevents the usage of keywords which are reserved in some database systems. Background is that there are no column prefixes anymore. For a list of all keywords see [the following section](#reserved-database-keywords).
* Mandatory fields may not be nullable, too. Occurs if you try to activate both `mandatory` and `nullable` properties for a field.
* The default/minimum/maximum value is too long for the specified field length.
* Fields using text or blob data types must not be unique (applies for text, array and object fields).
  
Note all rules for name validation are applied not only to `name`, but also to the `dbName` property, too, if it is set for a certain field.

##### Reserved database keywords

The following list has been merged and includes therefore all keywords of all supported DBMS.

* abort, access, accessible, account, action, activate, add, admin, after, against, aggregate, algorithm, alias, all, allocate, allow, alter, always, analyse, analyze, and, any, array, arraylen, as, asc, ascii, asensitive, associate, asutime, at, attach, attributes, audit, authorization, autoextend_size, autoincrement, auto_increment, aux, auxiliary, avg, avg_row_length
* backup, before, begin, between, bigint, binary, binlog, bit, blob, block, bool, boolean, both, break, browse, btree, bufferpool, bulk, by, byte
* cache, call, called, capture, cardinality, cascade, cascaded, case, cast, catalog_name, ccsid, chain, change, changed, channel, char, character, charset, check, checkpoint, checksum, cipher, class_origin, client, clone, close, cluster, clustered, coalesce, code, collate, collation, collection, collid, column, columns, column_format, column_name, comment, commit, committed, compact, completion, component, compress, compressed, compression, compute, concat, concurrent, condition, conflict, connect, connection, confirm, consistent, constraint, constraint_catalog, constraint_name, constraint_schema, contains, containstable, context, continue, controlrow, convert, count, count_big, cpu, create, cross, cube, cume_dist, current, current_date, current_lc_ctype, current_path, current_schema, current_server, current_time, current_timestamp, current_timezone, current_user, cursor, cursor_name, cycle
* data, database, databases, datafile, datapartitionname, datapartitionnum, date, datetime, day, days, day_hour, day_microsecond, day_minute, day_second, db2general, db2genrl, db2sql, dbcc, dbinfo, dbpartitionname, dbpartitionnum, deallocate, dec, decimal, declare, default, default_auth, defaults, deferrable, deferred, definer, definition, delayed, delay_key_write, delete, dense_rank, denserank, deny, desc, describe, descriptor, des_key_file, detach, deterministic, diagnostics, directory, disable, disallow, discard, disconnect, disk, distinct, distinctrow, div, distributed, do, document, double, drop, dssize, dummy, dual, dumpfile, duplicate, dynamic
* each, editproc, else, elseif, empty, enable, enclosed, encoding, encryption, end, end-exec, ending, ends, engine, engines, enum, erase, errlvl, error, errorexit, errors, escape, escaped, event, events, every, except, exception, exchange, excluding, exclusive, exec, execute, exists, exit, expansion, expire, explain, export, extended, extent_size, external, extract
* fail, false, fast, faults, fenced, fetch, fieldproc, fields, file, file_block_size, fillfactor, filter, final, first, first_value, fixed, float, float4, float8, floppy, flush, follows, for, force, foreign, format, found, free, freetext, freetexttable, freeze, from, full, fulltext, function
* general, generated, geometry, geometrycollection, get, get_format, glob, global, go, goto, grant, grants, graphic, group, grouping, groups, group_replication
* handler, hash, hashed_value, having, help, high_priority, hint, hold, holdlock, hour, hours, hour_microsecond, hour_minute, hour_second
* identified, identity, identitycol, identity_insert, if, ignore, ignore_server_ids, ilike, immediate, import, in, including, inclusive, increment, index, indexed, indexes, indicator, inf, infile, infinity, inherit, initial, initial_size, initially, inner, inout, insensitive, insert, insert_method, install, instance, instead, int, int1, int2, int3, int4, int8, integer, integrity, intersect, interval, into, invisible, invoker, io, io_after_gtids, io_before_gtids, io_thread, ipc, is, isnull, isobid, isolation, issuer, iterate
* jar, java, join, json, json_table
* keep, key, keys, key_block_size, kill
* label, lag, language, last, last_value, lateral, lc_ctype, lead, leading, leave, leaves, left, less, level, like, limit, linear, lineno, lines, linestring, linktype, list, load, local, localdate, locale, localtime, localtimestamp, locator, locators, lock, lockmax, locks, locksize, logfile, logs, long, longblob, longtext, loop, low_priority
* maintained, master, master_auto_position, master_bind, master_connect_retry, master_delay, master_heartbeat_period, master_host, master_log_file, master_log_pos, master_password, master_port, master_retry_count, master_server_id, master_ssl, master_ssl_ca, master_ssl_capath, master_ssl_cert, master_ssl_cipher, master_ssl_crl, master_ssl_crlpath, master_ssl_key, master_ssl_verify_server_cert, master_tls_version, master_user, match, materialized, max, maxextents, maxvalue, max_connections_per_hour, max_queries_per_hour, max_rows, max_size, max_updates_per_hour, max_user_connections, medium, mediumblob, mediumint, mediumtext, memory, merge, message_text, microsecond, microseconds, middleint, migrate, min, minus, minute, minutes, minute_microsecond, minute_second, minvalue, min_rows, mirrorexit, mod, mode, modifies, modify, month, months, multilinestring, multipoint, multipolygon, mutex, mysql_errno
* nan, national, natural, nchar, ndb, ndbcluster, never, new, new_table, next, nextval, no, noaudit, nocache, nocheck, nocompress, nocycle, nodegroup, nodename, nodenumber, nomaxvalue, nominvalue, nonclustered, none, noorder, normalized, not, notfound, notnull, nowait, no_wait, no_write_to_binlog, nth_value, ntile, null, nullif, nulls, number, numeric, numparts, nvarchar
* obid, of, off, offline, offset, offsets, old, old_table, on, once, one, online, only, open, opendatasource, openquery, openrowset, optimization, optimize, optimizer_costs, option, optionally, or, order, out, outer, outfile, over, overlaps, overriding, owner
* package, pack_keys, padded, page, pagesize, parameter, parser, part, partial, partition, partitioned, partitioning, partitions, password, path, pctfree, percent, percent_rank, perm, permanent, persist, phase, piecesize, pipe, placing, plan, plugin, plugins, plugin_dir, point, polygon, port, pragma, position, precedes, precision, prepare, preserve, prev, prevval, primary, print, prior, priqty, privileges, proc, procedure, processexit, processlist, profile, profiles, program, proxy, psid, public, purge,* quarter, query, queryno, quick
* raid0, raise, raiserror, range, rank, raw, read, reads, readtext, read_only, read_write, real, rebuild, reconfigure, recover, recovery, recursive, redofile, redo_buffer_size, redundant, references, referencing, refresh, regexp, reindex, relay, relaylog, relay_log_file, relay_log_pos, relay_thread, release, reload, remove, rename, reorganize, repair, repeat, repeatable, replace, replicate_do_db, replicate_do_table, replicate_ignore_db, replicate_ignore_table, replicate_rewrite_db, replicate_wild_do_table, replicate_wild_ignore_table, replication, require, reset, resignal, resource, restart, restore, restrict, result, result_set_locator, resume, return, returned_sqlstate, returns, reverse, revoke, right, rlike, role, rollback, rollup, rotate, round_ceiling, round_down, round_floor, round_half_down, round_half_even, round_half_up, round_up, routine, row, rowcount, rowguidcol, rowid, rowlabel, rownum, rownumber, rows, rowset, row_count, row_format, row_number, rrn, rtree, rule, run
* save, savepoint, schedule, schema, schemas, schema_name, scratchpad, scroll, search, second, seconds, second_microsecond, secqty, security, select, sensitive, separator, sequence, serial, serializable, server, session, session_user, set, setuser, share, show, shutdown, signal, signed, similar, simple, size, slave, slow, smallint, snan, snapshot, socket, some, soname, sounds, source, spatial, specific, sql, sqlbuf, sqlexception, sqlid, sqlstate, sqlwarning, sql_after_gtids, sql_after_mts_gaps, sql_before_gtids, sql_big_result, sql_buffer_result, sql_cache, sql_calc_found_rows, sql_no_cache, sql_small_result, sql_thread, sql_tsi_day, sql_tsi_hour, sql_tsi_minute, sql_tsi_month, sql_tsi_quarter, sql_tsi_second, sql_tsi_week, sql_tsi_year, ssl, stacked, standard, start, starting, starts, statement, static, statistics, statment, stats_auto_recalc, stats_persistent, stats_sample_pages, stay, stogroup, stop, storage, stored, stores, straight_join, string, style, subclass_origin, subject, subpartition, subpartitions, substring, successful, sum, summary, super, suspend, swaps, switches, synonym, sysdate, sysfun, sysibm, sysproc, system, system_user
* table, tables, tablespace, table_checksum, table_name, tape, temp, temporary, temptable, terminated, text, textsize, than, then, time, timestamp, timestampadd, timestampdiff, tinyblob, tinyint, tinytext, to, top, trailing, tran, transaction, trigger, triggers, trim, true, truncate, tsequal, type, types
* uid, uncommitted, undefined, undo, undofile, undo_buffer_size, unicode, uninstall, union, unique, unknown, unlock, unsigned, until, update, updatetext, upgrade, usage, use, user, user_resources, use_frm, using, utc_date, utc_time, utc_timestamp
* vacuum, validate, validation, validproc, value, values, varbinary, varchar, varchar2, varcharacter, variable, variables, variant, varying, vcat, verbose, version, view, virtual, visible, volatile, volumes
* wait, waitfor, warnings, week, weight_string, when, whenever, where, while, window, with, without, work, wrapper, write, writetext
* x509, xa, xid, xml, xmlelement, xmlexists, xmlnamespaces, xor
* year, years, year_month
* zerofill

#### Extension-related field settings

* The sluggable position values must be unique per entity. If fields are included into a slug by setting a value greater than `0`, this value must be unique per entity. The position defines in which order the field values are considered as permalink parts.
* Only one field per entity may store the sortable position. Can occur if one tries to use multiple integer or user fields as position for the sortable extension.
* The sortable position may not be the sortable group, too. As soon as a field is used as sortable position it can not also act as the grouping criteria at the same time.
* You need another field as sortable position to make the sortable group work. Can occur for a field or a many to one relationship marked as sortable group if no integer field is marked as sortable position.
* Only one field per entity may store the version. Can appear for integer fields if you enabled the `version` property for more than one field in the same entity.
* Only one field per entity may represent a start date. Can appear for datetime and date fields if you enabled the `start date` property for more than one field in the same entity.
* Only one field per entity may represent an end date. Can appear for datetime and date fields if you enabled the `end date` property for more than one field in the same entity.
* Entities with a version field must use optimistic locking. Can appear for integer fields with the `version` property enabled. You must set the locking type of the corresponding entity to `OPTIMISTIC`.
* Entities with optimistic locking must contain a field declared as version field. The opposite rule to ensure that every entity using optimistic locking has a version field for storing and comparison the version as locking criteria.
* The version attribute can not be combined with a primary key. A field can only act as either a version or a primary key, not both at the same time.
* Entities with geographical extension have additional fields names (`longitude`, `latitude`). Thus your (fields may not contain these names | reference may not contain these (source | target) aliases). If an entity has activated the `geographical` extension ModuleStudio creates coordinate fields automatically in addition to the other fields in the model (as well as some usage of geolocation when creating new entities).
* Entities with sluggable fields have an additional field for the permalink (`slug`). Thus your (fields may not contain this name | reference may not contain this (source | target) alias). If at least one entity field has set the `sluggable position` attribute to a number greater than `0` ModuleStudio creates a field named `slug` automatically in addition to the other fields in the model.
* Entities with translatable fields have an additional field for the language code (`locale`). Thus your (fields may not contain this name | reference may not contain this (source | target) alias). If at least one entity field has activated the `translatable` extension ModuleStudio creates a field named `locale` automatically in addition to the other fields in the model.
* Entities with tree extension have additional fields names (`lft`, `lvl`, `rgt`, `root`, `parent`, `children`). Thus your (fields may not contain these names | reference may not contain these (source | target) aliases). If an entity has activated the `tree` extension ModuleStudio creates these fields automatically in addition to the other fields in the model (as well as a convenient hierarchy management page). This does apply on both tree strategies (`nested set` as well as `closure`).
* Entities with categories have an additional field for referencing these (`categories`). Thus your (fields may not contain this name | reference may not contain this (source | target) alias). If an entity has activated the `categorisable` extension ModuleStudio creates an additional relation to store the collection of categories for a certain entity.
* Entities with enhanced workflows need standard fields for creator identification. If you enabled another workflow than `NONE` you may not disable the `standard fields` extension because the creator is used for sending notifications to the moderators.
* Entities with Zikula standard fields extension have an additional additional fields (`createdDate`, `createdBy`, `updatedDate`, `updatedBy`). Thus your (fields may not contain these names | reference may not contain these (source | target) aliases). If an entity has activated the `standard fields` extension ModuleStudio creates some additional fields to store these for a certain entity.

#### Numeric fields

* The default value for an integer field must contain only digits.
* The maximum length for an integer field is `18`. Corresponds to a `bigint` mapping in Doctrine 2.
* Minimum value must not be larger than maximum value.
* An integer field must not act as `percentage` and `range` at the same time.
* Entities with an aggregate field should use a locking strategy (optimistic or pessimistic read). If an integer field acts as aggregate field the corresponding entity must use one locking strategy of `OPTIMISTIC` or `PESSIMISTIC_READ`.
* Aggregate fields work only in combination with an outgoing and bidirectional one-to-many relationship with persist cascade.
* Naming of aggregateFor attribute values must follow the syntax `targetAlias#targetFieldName` (for example `views#amount`). If an integer field acts as aggregate field the property `aggregate for` must define the target alias of corresponding outgoing and bidirectional one-to-many relationship with persist cascade. After a `.` char as delimiter the name of the target field (to be aggregated) follows.
* The default value for a number field must be a floating point number.
* The length (precision) of a number field must be greater than the scale. For example `1234.12` is valid (4 > 2), but `123.1234` is not.
* A number field must not act as `percentage` and `currency` at the same time.

#### String and text fields

* String size must not be smaller than `1`. Occurs if length is set to `0`.
* String size must be larger than minimum length. If you set a minimum length it must not be larger than the actual field length.
* String length for BIC numbers must be at least `12` chars. Occurs if you activate the `bic` role for a string field with a length smaller than `12`.
* String length for colour codes must be at least `7` chars. Occurs if you activate the `colour` role for a string field with a length smaller than `7`.
* String length for country codes must be at least `2` chars. Occurs if you activate the `country` role for a string field with a length smaller than `2`.
* String length for credit card numbers must be at least `20` chars. Occurs if you activate the `credit card` role for a string field with a length smaller than `20`.
* String length for currency codes must be at least `3` chars. Occurs if you activate the `currency` role for a string field with a length smaller than `3`.
* String length for IBAN numbers must be at least `34` chars. Occurs if you activate the `iban` role for a string field with a length smaller than `34`.
* String length for icons must be at least `50` chars. Occurs if you activate the `icon` role for a string field with a length smaller than `50`.
* String length for ISBN numbers must be at least `17` chars. Occurs if you activate the set the `isbn` property for a string field with a length smaller than `17`.
* String length for ISSN numbers must be at least `9` chars. Occurs if you activate the set the `issn` property for a string field with a length smaller than `9`.
* String length for languages must be at least `7` chars. Occurs if you activate the `language` role for a string field with a length smaller than `7`.
* String length for locales must be at least `5` chars. Occurs if you activate the `locale` role for a string field with a length smaller than `5`.
* String length for IP addresses must be at least `15` chars. Occurs if you set the `ip address` property to a value covering IPv4 addresses for a field with a length smaller than `15`.
* String length for IP addresses must be at least `39` chars. Occurs if you set the `ip address` property to a value covering IPv6 addresses or if you enable the `ipTraceable` extension for a field with a length smaller than `39`.
* String length for phone numbers must be at least `8` chars. Occurs if you activate the `phone_number` role for a string field with a length smaller than `8`.
* String length for time zones must be at least `30` chars. Occurs if you activate the `timezone` role for a string field with a length smaller than `30`.
* String length for UUIDs must be at least `36` chars. Occurs if you activate the `uuid` role for a string field with a length smaller than `36`.
* String length for week numbers must be at least `8` chars. Occurs if you activate the `week` role for a string field with a length smaller than `8`.
* A string can only have one special semantic (role, isbn, issn, ip address).
* String length must not be greater than `255`; for bigger sizes use text fields.
* The default value for an email field must be a valid email address.
* The default value for an url field must be a valid url. Allowed protocols are `http`, `ftp` and `https`.
* The ipTraceable change trigger field must point to `workflowState`, the name of a field or a relation (property.field). If the `ipTraceable` property for a field has been set to `CHANGE` then this error can appear to remind you to set also the required attribute `ipTraceable change trigger field`. Either you did not set anything there or the value does neither correspond to `workflowState` nor the name of an entity field nor an incoming relation.

#### User fields

* The blameable change trigger field must point to `workflowState`, the name of a field or a relation (property.field). If the `blameable` property for a field has been set to `CHANGE` then this error can appear to remind you to set also the required attribute `blameable change trigger field`. Either you did not set anything there or the value does neither correspond to `workflowState` nor the name of an entity field nor an incoming relation.

#### Date and time fields

This section includes rules which apply only for datetime, date and time fields.

* A value can not be in the past and in the future at the same time. You can only activate either `past` or `future` validators for one field.
* A value can not represent both start and end date at the same time. You can only activate either `start date` or `end date` flags for one field.
* The timestampable change trigger field must point to `workflowState`, the name of a field or a relation (property.field). If the `timestampable` property for a field has been set to `CHANGE` then this error can appear to remind you to set also the required attribute `timestampable change trigger field`. Either you did not set anything there or the value does neither correspond to `workflowState` nor the name of an entity field nor an incoming relation.
* The default value for a datetime field must conform to the pattern `YYYY-MM-DD HH:MM:SS` or `now`. You can either set a certain value or use `now` to specify the current timestamp.
* The default value for a date field must conform to the pattern `YYYY-MM-DD` or `now`. You can either set a certain value or use `now` to specify today.
* The default value for a time field must conform to the pattern `HH:MM:SS` or `now`. You can either set a certain value or use `now` to specify the current moment.
* Time fields may not act as start/end date.

#### Upload fields

* The `allowed extensions` attribute must contain a comma separated list of the file types to be allowed during the upload (example: `gif, jpeg, jpg, png`). Note that the separator is `', '` including the space char.
* There must not exist a field named `fooMeta` because this is reserved for an automatic field storing meta data for this upload.
* Minimum image width must not be larger than maximum image width.
* Minimum image height must not be larger than maximum image height.
* Minimum image aspect ratio must not be larger than maximum image aspect ratio.
* Either square or landscape or portrait images must be allowed.

#### List fields

* The list must contain at least one item.
* The list must contain at least two items. Occurs if you enable `multiple` without having defined multiple list items.
* The list is not set to multiple and may therefore only contain one item with `default` property set to `true`.
* List item values must be unique.
* Only lists with multiple selections can define an enforced minimum (maximum) amount of selected values. Occurs if you set `min` (`max`) to a value not equal to `0`, without having set `multiple = true`.
* The amount of list items must not be smaller than the minimum (maximum) amount of enforced values. Occurs if you set `min` (`max`) to a value which is greater than the actual number of existing list items.
* The maximum amount of enforced values must not be smaller than the minimum amount of enforced values. Occurs if you set `max` to a smaller value than `min`.

#### Array fields

* Enforcing a certain amount of items requires setting both `min` and `max` properties. Occurs if you set either `min` or `max` to a value greater than `0`, but not both.
* The maximum amount of enforced items must not be smaller than the minimum amount of enforced items. Occurs if you set `max` to a smaller value than `min`.

### Relationship

* Every relation must have a (source | target) data object.
* Every relation must have a (source | target) alias. Aliases must have a length of at least two chars. Recommended are at least four chars.
* Relationship source aliases must be unique for all incoming relations of an entity.
* Relationship target aliases must be unique for all outgoing relations of an entity.
* Relationship source aliases must not be named like a field of the target entity.
* Relationship target aliases must not be named like a field of the source entity.

#### Join relationship

Includes basically all relationships in the data layer except inheritance.

* The (`sourceField` | `targetField`) attribute must contain either `id` for automatic primary key or a comma separated list of (source | target) fields to be referenced. Note that the separator is `', '` including the space char.
* The amount of join columns must be equal for association source and target sides. If source or target field are not `id` ModuleStudio splits both values by the separator above and compares the amount of elements on both sides. This enables joins over multiple fields.
* The field `sourceField` | `targetField` must be an integer field with a length of `11`. Is only checked if the (source | target) field is named `id`.
* The fields `sourceField` and `targetField` must have the same type and length values. Is only checked if the source and target fields are both not named `id`.
* Self relation must not reference the `sourceField` field for both source and target. For self relation the source field must not be equal to the target field (as the database needs two fields in order to store both sides).
* Between two entities there must not be multiple join relations with cascade options.

#### One to many relationship

* The `orderBy` attribute points to an invalid field of the target entity. Checks whether the target entity contains a field equally named like the `orderBy` property. In case multiple fields are used in the `orderBy` property each single field is validated.
* The `indexBy` attribute points to an invalid field of the target entity. Checks whether the target entity contains a field equally named like the `indexBy` property.
* IndexBy fields must be unique. The target entity field used for `indexBy` must have the `unique` validator enabled.
* Enforcing a certain amount of items on the target side requires setting both `minTarget` and `maxTarget` properties. Occurs if you set either `minTarget` or `maxTarget` to a value greater than `0`, but not both.
* The maximum amount of enforced items on the target side must not be smaller than the minimum amount of enforced items. Occurs if you set `maxTarget` to a smaller value than `minTarget`.
* Embedded editing is not supported (yet) for multi-valued association sides. Occurs if you set `targetEditing=EMBEDDED`.

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
* Embedded editing is not supported (yet) for multi-valued association sides. Occurs if you set `sourceEditing=EMBEDDED` or `targetEditing=EMBEDDED`.

#### Inheritance relationship

* The `discriminatorColumn` attribute must not be empty for inheritance relations. Per default this attribute has the value `discr` so this shouldn't happen as long as you don't delete this value. ModuleStudio uses this value to tell Doctrine 2 where to store the type of stored entities.
* Please rename the `discriminatorColumn` field as it is reserved for the discriminator column, or change corresponding attribute. Happens if the target entity includes a field with the same name as specified in the `discriminator` setting.
* Self inheritance relations and inheritance cycles are not allowed. Recursive check to detect cycles within inheritance hierarchies.
* All inheritance connections within a class hierarchy must have the same inheritance strategy.
* All inheritance connections within a class hierarchy must have the same discriminator column.
* An entity can not inherit from multiple entities.

### Entity index

* Every index must have a name. The index name must have a length of at least two chars. Recommended are at least four chars.
* Every index must contain at least one item referencing an entity field.
* The length of all index fields must not be higher than `191`. The limit is `767` bytes, while UTF-8 requires four bytes for each char.
* Index names must be unique per entity.
* Index item names must be unique per index.

#### Entity index item

* Every index item must have the same name as the referenced entity field or incoming bidirectional one to many relationship source alias. This occurs if no equally named field or foreign key is found in the entity.

### Variables

* Every var container must have a name.
* Var container names must be unique.
* Var container sort positions must be unique.
* Every var container must contain at least one variable.
* Variable names must be unique.

### Calculated field

* The field must rely on at least one derived field. Not relevant yet, this is for future.

## Controller layer

### Controller

* Entity name is a reserved identifier (`ajax`, `theme`). These names are reserved.
* There must not exist more than one (`index` | `detail` | `edit` | `delete`) action in one entity.
* Names of custom actions in one entity must be unique.

### Action

#### Custom action

* The action must have a name. Action name must not be `New`. Must have a length of at least four chars, whereby at least six chars are recommended.
* Action name must not be `Index`, `Detail`, `Edit` or `Delete`. These are reserved names and may therefore not be used for custom actions.
