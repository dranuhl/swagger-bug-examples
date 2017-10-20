# swagger-bug-examples/bug-response-list-jaxrs1

**NOTE:** This repository is just to show-case issues found within the
[Swagger I/O framework](https://www.swagger.io).  It is not maintained and might be out-of-date.

This Swagger I/O issue example provides details with respect to
- Java annotation `@XmlAttrbiute` is not used by swagger-core and so these field are missing if `@XmlAccessorType(XmlAccessType.NONE)` is used.
- `@XmlRootElement(namespace="")` is not applied correctly if `@XmlSchema` is used at package-level
- Any REST resource method whose response is `List<Object>` without usage of `response` and `responseContainer` parameters of `@ApiOperation` annotation will not automatically add the `xml: {wrapped:true}` and correct XML name for the wrapper.<br>
  See also [Swagger-Core Issue 2334](https://github.com/swagger-api/swagger-core/issues/2334), which covers this issue with full `@ApiOperation(response=..., responseContainer="list")` usage.

using
- swagger-jersey-jaxrs 1.5.16
- swagger-ui 2.2.10 / swagger-ui 3.0.21

## Steps to reproduce

- compile using Maven and Java 7 (or newer)
- deploy on a servlet container of your choice, assuming its accessible via `http://localhost:8080/swagger-bug-examples` as base URL.
- `curl -v -H 'Accept: application/xml' http://localhost:8080/swagger-bug-examples/api/list`
- `curl -v -H 'Accept: application/xml' http://localhost:8080/swagger-bug-examples/api/items`
- use the web browser of your choice to access Swagger UI 2.2.10 or 3.0.21 using the generated JSON/YAML from the Java source
  * http://localhost:8080/swagger-bug-examples/docs-2.x for swagger-ui 2.2.10 usage
  * http://localhost:8080/swagger-bug-examples/docs-3.x for swagger-ui 3.0.21 usage
- compare the above with the hand-crafted JSON for the respective Swagger UIs by accessing
  * http://localhost:8080/swagger-bug-examples/docs-2.x-expected for swagger-ui 2.2.10 usage
  * http://localhost:8080/swagger-bug-examples/docs-3.x-expected for swagger-ui 3.0.21 usage
- compare the hand-crafter JSON (see above) with the JSON/YAML generated from the Java source, which can be retrieved via
  * `curl -v http://localhost:8080/swagger-bug-examples/api/swagger.json`
  * `curl -v http://localhost:8080/swagger-bug-examples/api/swagger.yaml`

See also [Swagger Online Forum for details](https://swagger.io/forum/#!msg/swagger-swaggersocket/vGOJ3Hby0E4/PVov28dmAQAJ).
