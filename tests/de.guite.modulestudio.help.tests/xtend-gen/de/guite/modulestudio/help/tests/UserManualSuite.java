package de.guite.modulestudio.help.tests;

import de.guite.modulestudio.help.tests.manual.BasicApplicationClassTestsSpec;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@Named("User Manual")
@Contains(BasicApplicationClassTestsSpec.class)
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class UserManualSuite {
}
