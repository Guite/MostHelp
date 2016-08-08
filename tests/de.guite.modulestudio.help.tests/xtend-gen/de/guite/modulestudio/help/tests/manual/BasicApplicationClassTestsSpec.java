package de.guite.modulestudio.help.tests.manual;

import org.jnario.lib.Assert;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This class tests certain aspects of the Application meta class.
 */
@Named("Basic application class tests")
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class BasicApplicationClassTestsSpec {
  /**
   * First dummy test.
   */
  @Test
  @Named("Just a dummy test")
  @Order(1)
  public void _justADummyTest() throws Exception {
    Assert.assertFalse("\nExpected (2-1) should not be 5 but"
     + "\n     2-1 is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf((2 - 1))).toString() + "\n", Should.<Integer>should_be(Integer.valueOf((2 - 1)), Integer.valueOf(5)));
    
  }
}
