Universal Editor Redirect
======
[![Build](https://github.com/diva-e-aem/com.divae.rnd.universaleditor.redirect/workflows/Build/badge.svg?branch=develop)](https://github.com/diva-e-aem/com.divae.rnd.universaleditor.redirect/actions?query=workflow%3ABuild+branch%3Adevelop)

If you run Universal Editor locally with a local AEMaaCS SDK instance and an EDS/X-Walk application, when you hit the "edit" button you will get a HTTP 404 when the url "/ui#..." is called.

This bundle implements a simple redirect which redirects those URLs to

    https://experience.adobe.com/#/@myenvironment/aem/editor/canvas/localhost:8443/<content-path>

This redirect target URL is configurable via OSGi configuration.

In effect the edit button should work.