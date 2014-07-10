Maven 3.x Hello World Plugin Examples
=====================================

There are 2 techniques demonstrated here.

hello-oldworld-maven-plugin
---------------------------

Implements the ":info" goal.

This build uses the by convention techniques of building out a maven plugin based on defaults cooked into maven already.  The `<packaging>maven-plugin</packaging>` is a hint to maven itself on how to build out this project.  It will run (on maven 3.2.2 that i tested with) the following plugins (in this order) with the provided goals of `clean install`

  * maven-clean-plugin:2.5:clean
  * maven-plugin-plugin:3.2:descriptor
  * maven-resources-plugin:2.6:resources
  * maven-compiler-plugin:2.5.1:compile
  * maven-resources-plugin:2.6:testResources
  * maven-compiler-plugin:2.5.1:testCompile
  * maven-surefire-plugin:2.12.4:test
  * maven-jar-plugin:2.4:jar
  * maven-plugin-plugin:3.2:addPluginArtifactMetadata
  * maven-install-plugin:2.4:install

Where did this list come from?
Well, its part of the Maven [default bindings for `maven-plugin`](https://github.com/apache/maven/blob/maven-3.2.2/maven-core/src/main/resources/META-INF/plexus/default-bindings.xml#L184-L230)

This project uses the old-school javadoc notations for defining the mojo. (while it appears to be javadoc / doclet related, it does not use the doclet approach to get that information out)

The end result of this build is a jar file, with the appropriate xml descriptors for the plugin (`META-INF/maven/plugin.xml`) built-out from the javadoc notations.

To build:

    > cd hello-oldworld-maven-plugin
    > mvn clean install

To test:

    > cd my-maven-project
    > mvn com.github.erdfelt.examples:hello-oldworld-maven-plugin:info

To demonstrate plugin configuration:

    > cd my-maven-project
    > mvn com.github.erdfelt.examples:hello-oldworld-maven-plugin:info -DoutputDir=/tmp


hello-world-maven-plugin
------------------------

This also implements the `:info` goal.

However, it uses the `maven-plugin-annotations` (eg: `@Mojo`, `@Component`, `@Parameter`) to set itself up, along with some extra maven plugins to build out some extra goodies (such as the `HelpMojo` for commandline help on your plugin)

End result is the same, a jar file with the plugin descriptor built-out (`META-INF/maven/plugin.xml`)

To build:

    > cd hello-world-maven-plugin
    > mvn clean install

To test:

    > cd my-maven-project
    > mvn com.github.erdfelt.examples:hello-world-maven-plugin:info

To demonstrate plugin configuration:

    > cd my-maven-project
    > mvn com.github.erdfelt.examples:hello-world-maven-plugin:info -DoutputDir=/tmp


