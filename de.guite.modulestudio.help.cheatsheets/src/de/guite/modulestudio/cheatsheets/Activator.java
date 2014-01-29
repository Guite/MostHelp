package de.guite.modulestudio.cheatsheets;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

    /**
     * The plug-in ID.
     */
    public static final String PLUGIN_ID = "de.guite.modulestudio.cheatsheets"; //$NON-NLS-1$

    /**
     * The shared instance.
     */
    private static Activator plugin;

    /**
     * The constructor.
     */
    public Activator() {
        // nothing to do here
    }

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    // @SuppressWarnings("PMD.SignatureDeclareThrowsException") We have to use
    // this signature because this is an override of an Eclipse framework's
    // method.
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    @Override
    @SuppressWarnings({ "PMD.SignatureDeclareThrowsException",
            "PMD.NullAssignment" })
    // @SuppressWarnings("PMD.SignatureDeclareThrowsException") We have to use
    // this signature because this is an override of an Eclipse framework's
    // method.
    // @SuppressWarnings("PMD.NullAssignment")
    // No choice to right it in another way : this is an Eclipse pattern.
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }
}
