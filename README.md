Universal Editor Redirect
======
[![Build](https://github.com/diva-e-aem/com.divae.rnd.universaleditor.redirect/workflows/Build/badge.svg?branch=develop)](https://github.com/diva-e-aem/com.divae.rnd.universaleditor.redirect/actions?query=workflow%3ABuild+branch%3Adevelop)

**UPDATE**: this bundle is obsolete - you can achieve this with OSGi configuration as well - example:

```json
"com.day.cq.wcm.core.impl.AuthoringUIModeServiceImpl": {
  "authoringUIModeService.default": "TOUCH",
  "authoringUIModeService.editorUrl.classic": "/cf#",
  "authoringUIModeService.editorUrl.touch": "/editor.html",
  "authoringUIModeService.editorUrl.universal": "$[env:AEM_UNIVERSAL_EDITOR_PATH;default=https://experience.adobe.com/#/@myenvironment/aem/editor/canvas/]",
  "authoringUIModeService.resourceTypes.universal": ["core/franklin/components/page/v1/page"]
},
"com.day.cq.commons.impl.ExternalizerImpl": {
  "externalizer.domains": [
    "local $[env:AEM_EXTERNALIZER_LOCAL;default=https://localhost:8443]",
    "author $[env:AEM_EXTERNALIZER_AUTHOR;default=https://localhost:8443]",
    "publish $[env:AEM_EXTERNALIZER_PUBLISH;default=https://localhost:4503]",
    "preview $[env:AEM_EXTERNALIZER_PREVIEW;default=https://localhost:4503]"
  ]
}
```

---

If you run Universal Editor locally with a local AEMaaCS SDK instance and an EDS/X-Walk application, when you hit the "edit" button you will get a HTTP 404 when the url "/ui#..." is called.

This bundle implements a simple redirect which redirects those URLs to

    https://experience.adobe.com/#/@myenvironment/aem/editor/canvas/localhost:8443/<content-path>

This redirect target URL is configurable via OSGi configuration.

In effect the edit button should work.