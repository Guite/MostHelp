package de.guite.modulestudio.help.tests;

import de.guite.modulestudio.help.tests.UnitTestsSuite;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@Named("Help Testing Suite")
@Contains(UnitTestsSuite.class)
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class HelpTestingSuiteSuite {
}
