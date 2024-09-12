package com.divae.rnd.universaleditor.redirect.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 * Redirect OSGi configuration.
 */
@Component(service = RedirectConfig.class, immediate = true)
@Designate(ocd = RedirectConfig.Config.class)
public class RedirectConfig {

  @ObjectClassDefinition(
      name = "Universal Editor Redirect Configuration",
      description = "Configures redirect for /ui URL.")
  @interface Config {

    @AttributeDefinition(
        name = "Redirect Target",
        description = "Path to redirect to when /ui#... is called - the current content path is appended to the URL.")
    String redirectTarget() default "https://experience.adobe.com/#/@myenvironment/aem/editor/canvas/localhost:8443";
  }

  private String redirectTarget;

  @Activate
  private void activate(Config config) {
    redirectTarget = config.redirectTarget();
  }

  /**
   * @return Redirect target
   */
  public String getRedirectTarget() {
    return this.redirectTarget;
  }

}
