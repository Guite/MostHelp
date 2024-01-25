# Installation

Simply download the archive for your operating system and extract it inside your home directory. You can also choose any other directory, but your user needs to have write access to it. Otherwise the automatic update functionality will not work correctly. As it seems Eclipse has problems with pathes containing space chars, avoid spaces in the directory path to ensure things work correctly.

Afterwards you are ready to start the ModuleStudio executable.

ModuleStudio requires at least **Java 11 (64 bit)**, but it comes with Java 17.0.6 already included. So it should start also if you have an older version or no Java installed at all.

## Additional notes for Windows

- Because Windows has a limit of 260 characters for paths, do not choose a too nested directory, but ideally a simple path like `C:\ModuleStudio\`.

## Additional notes for Linux and MacOSX

Make sure to include the `-p` flag if you extract the `.tar.gz` to keep the correct permissions (for example: `tar -xpzvf ModuleStudio-linux.gtk.x86_64.tar.gz`).

## The workspace

ModuleStudio stores any temporary data as well as your project files in a special directory which is named `MostWorkspace` and located in your user home directory. So if you want to create a backup of a model look within `~/MostWorkspace/<YourProjectName>/`.

This location is rather fixed and not configurable within the application. However, it is possible to change it nevertheless like shown [below](#custom-workspace-directory). 

## Updating ModuleStudio

Every time you start ModuleStudio it searches for available updates. In case an update is found ModuleStudio asks whether it should download and install. If yes, it performs these actions and restarts afterwards. In general it is reasonable to install updates, as they contain generator bug fixes in most cases and maybe also new features. However, there are situations where you could decide against it: for example if an obsolete Symfony target version is not longer supported in a new version, but you still work with it, you should stay with your current version.

By default MOST looks only for stable versions. You can also enable *staging updates* in the [preferences](38-Preferences.md#modulestudio-base-preferences) though in order to include also unstable updates which includes every new build. You can read more about staging updates [here](38-Preferences.md#modulestudio-base-preferences).

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

Please ensure that the configured directory is writable.
