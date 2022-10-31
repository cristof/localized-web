## Test project

This project is intended to be used as a test playground for localization issues on myfaces and mojarra JSF 2.3+ implementations.

It depends on [localized-components project](https://github.com/cristof/localized-components) as a way to test access to jar built JSF composite components. 

The issues are described on [mojarra](https://github.com/eclipse-ee4j/mojarra/issues/5160) and [myfaces](https://issues.apache.org/jira/browse/MYFACES-4491) projects.

# Usage

To check the issue, you must clone and install [localized-components project](https://github.com/cristof/localized-components) and, after cloning this project, run it using:

```
mvn -Pjakarta8-mojarra clean package tomee:run
```
You may also use the profiles `jakarta9-mojarra`, `jakarta8-myfaces` and `jakarta9-myfaces`. If you want, you may also change `jsf.stage` to `Development` using `-Djsf.stage=Development` if needed.

After compiling and installing locally the fixed SNAPSHOT versions of mojarra 2.3, mojarra 3.0, myfaces 2.3 and myfaces 3.0, you may test all them using the following profiles:

- `jakarta8-mojarra-fixed`
- `jakarta9-mojarra-fixed`
- `jakarta8-myfaces-fixed`
- `jakarta9-myfaces-fixed`

