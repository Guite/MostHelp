package de.guite.modulestudio.help.tests;

import de.guite.modulestudio.help.tests.CheatSheetsSuite;
import de.guite.modulestudio.help.tests.IntroPagesSuite;
import de.guite.modulestudio.help.tests.UserManualSuite;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@Named("Unit tests")
@Contains({ UserManualSuite.class, IntroPagesSuite.class, CheatSheetsSuite.class })
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class UnitTestsSuite {
}
