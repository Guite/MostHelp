# Installation

Simply download the archive for your operating system and extract it inside your home directory. You can also choose any other directory, but your user needs to have write access to it. Otherwise the automatic update functionality will not work correctly. As it seems Eclipse has problems with pathes containing space chars, avoid spaces in the directory path to ensure things work correctly.

Afterwards you are ready to start the ModuleStudio executable.

ModuleStudio requires Java 8, but includes it already. So it should start also if you have an older version or no Java installed at all.

## Additional notes for Windows

Because Windows has a limit of 260 characters for pathes, do not choose a too nested directory, but ideally a simple path like `C:\ModuleStudio\`.

## Additional notes for Linux and MacOSX

Make sure to include the -p flag if you extract the `.tar.gz` to keep the correct permissions (for example: `tar -xpzvf ModuleStudio-linux.gtk.x86_64.tar.gz`).

## The workspace

ModuleStudio stores any temporary data as well as your project files in a special directory which is named `MostWorkspace` and located in your user home directory. So if you want to create a backup of a model look within `~/MostWorkspace/<YourProjectName>/`.

This location is rather fixed and not configurable within the application. However, it is possible to change it nevertheless like shown [below](#custom-workspace-directory). 

## Updating ModuleStudio

Every time you start ModuleStudio it searches for available updates. In case an update is found ModuleStudio asks whether it should download and install. If yes, it performs these actions and restarts afterwards. In general it is reasonable to install updates, as they contain generator bug fixes in most cases and maybe also new features. However, there are situations where you could decide against it: for example if an obsolete Zikula core target is not longer supported in a new version, but you still work with it, you should stay with your current version.

By default MOST looks only for stable versions. You can also enable *staging updates* in the [preferences](38-Preferences.md#modulestudio-base-preferences) though in order to include also unstable updates which includes every new build. You can read more about staging updates [here](38-Preferences.md#modulestudio-base-preferences).

## Starting in a different language

ModuleStudio uses the language of your operating system if a fitting localisation is available (at the moment only English and German are supported). But it is also possible to enforce using a specific language.

So if your operating system is running in a language other than the one you want to start ModuleStudio in (for example, you are using German version of Windows, and you want to start Eclipse in English, provided that you have the required operating system language support including the keyboard layouts and input method editors installed), you have to specify the `-nl <locale>` command line argument when you launch ModuleStudio.

### Windows

On Windows, there are two ways to specify command line arguments for ModuleStudio:

* *Command line:* Open a Windows Command Prompt and change directory to the directory where ModuleStudio is installed. Then enter the following command to launch ModuleStudio in for example English: `modulestudio.exe -nl en`.
* *Windows shortcut:* Create a shortcut for the ModuleStudio executable file (for example, `C:\ModuleStudio\modulestudio.exe`). Select *Properties* from the pop-up menu for the shortcut. Append the `-nl en` command line argument to the end of the *Target* field. Click *OK* to save the changes. Afterwards you can double-click the shortcut to launch ModuleStudio in English.

### Mac OS X

On Mac OS X, if you need to pass arguments to ModuleStudio, you'll have to edit the `Info.plist` file inside the ModuleStudio application bundle:

* Select the ModuleStudio application bundle icon while holding down the Control key (this will present you with a pop-up menu).
* Select *Show Package Contents* in the pop-up menu.
* Locate the `Info.plist` file in the *Contents* subfolder and open it with your favourite text editor.
* Add the command line option `<string>-nl</string><string>en</string>` at the end of the *Eclipse* key (before the closing *array* element `</array>`).
* Save the changes.
* Double-click the ModuleStudio application bundle icon to launch ModuleStudio in English.

### Linux

On Linux, the easiest way is using the command line using your favourite console tool: change directory to the directory where ModuleStudio is installed. Then enter the following command to launch ModuleStudio in for example English: `./modulestudio -nl en`.


## Custom workspace directory

If you want to change the path where ModuleStudio persists its data edit the `modulestudio.ini` file using a text editor.

Locate the following setting:

```
-data
@user.home/MostWorkspace
```

You can change this to any other path. Note you need to use forward slashes also for Windows machines.

For example:

```
-data
/path/to/any/directory
```

or


```
-data
C:/Users/some/other/directory
```

Please ensure that the configured directory is writable,
