# Installation

Simply download the archive for your operating system and extract it inside your home directory. You can also choose any other directory, but your user needs to have write access to it. Otherwise the automatic update functionality will not work correctly. As it seems Eclipse has problems with pathes containing space chars, avoid spaces in the directory path to ensure things work correctly.

Afterwards you are ready to start the ModuleStudio executable.

ModuleStudio 0.7.0 and later requires Java 8, but includes it already. So it should start also if you have an older version or no Java installed at all.

## Additional notes for Windows

Because Windows has a limit of 260 characters for pathes, do not choose a too nested directory, but ideally a simple path like `C:\ModuleStudio\`.

If you use Windows 8 or later and enabled the SmartScreen protection starting ModuleStudio will open a blocking window showing the following error message: `Windows SmartScreen prevented an unrecognized program from starting. Running this program might put your PC at risk`.

This does not mean that ModuleStudio includes any kind of malware. Instead this message is only caused by the fact that the executable file is not digitally signed using a certificate yet. To start ModuleStudio nevertheless you should be able to use the right mouse button and choose `allow`. If this is not available click on the `More info` link and on the `Run anyway` button afterwards.

## Additional notes for Linux and MacOSX

Make sure to include the -p flag if you extract the `.tar.gz` to keep the correct permissions (for example: `tar -xpzvf ModuleStudio-linux.gtk.x86_64.tar.gz`).
