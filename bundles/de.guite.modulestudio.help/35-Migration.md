# Migration

## Open existing models

Projects which have been created before can simply be opened again by selecting them in a list presented in a dialog. 

## Importing model files

To import an existing model use the corresponding menu or dashboard action. The model will be migrated to the current DSL version and imported into a new project automatically. The name of this project is determined from the file name. So if you want to duplicate a model you need to rename the file before importing it. Otherwise you will see an error message because the project does already exist.

## Migrating old modules

If you want create a new model for an existing legacy module using DBUtil you can follow the following procedure.

1. First get the file *pntablesToXML.php* from [GitHub](https://github.com/zikula/core/blob/1.4.3/tools/pntablesToXML.php).
2. Use this script to convert your old `pntables.php` file into an xml file.
3. Inside ModuleStudio use the menu entry *File > Open model > Import xml table definition* which will open a file selection dialog. Choose the xml file you just created. As a result you will get a new application model in the `MOST_output/yourmod.mostapp` file.
4. Now import this model using the corresponding menu or dashboard action.
5. In the data editor remove unneeded elements, like table prefixes and default identifier fields, that are primary and foreign keys.
6. Follow validation messages to get remaining stuff sorted properly.

Example import results:

![Admin module](images/import_admin.png "Admin module")

![News module](images/import_news.png "News module")

![Content module](images/import_content.png "Content module")
