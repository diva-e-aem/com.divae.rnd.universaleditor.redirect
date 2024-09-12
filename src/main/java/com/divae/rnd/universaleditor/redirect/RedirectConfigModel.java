package com.divae.rnd.universaleditor.redirect;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.divae.rnd.universaleditor.redirect.impl.RedirectConfig;

/**
 * Sling Model to access redirect configuration.
 */
@Model(adaptables = SlingHttpServletRequest.class)
public class RedirectConfigModel {

  @OSGiService
  private RedirectConfig redirectConfig;

  /**
   * @return Redirect target
   */
  public String getRedirectTarget() {
    return redirectConfig.getRedirectTarget();
  }

}
