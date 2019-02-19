Conditional Stream
==================

[![Maven Central][maven-central-badge]][search-maven-artifact]
[![License][license-badge]][license]

Conditional Stream merges if/else, switch/case statements and finally block in a single stream of
given generic type object.

Method names cannot be same with Java Language Keywords, so the method names of Conditional Stream 
are little different from keywords but not that much.

* #### fi
  Perform function if given condition returns true.

* #### witch
  Perform function if stream object and given object are equal.

* #### elsa
  Classic else statement.

* #### finalize
  Performs given function without condition and finishes the stream.

* #### brach
  Changes stream type to return type of given function.

* #### cast
  Casts stream type to given type.

* #### get
  Returns final value of stream object as type of stream.

Download
--------

Download [the latest JAR][latest-jar]

#### Apache Maven
```xml
<dependency>
  <groupId>com.github.kaygisiz</groupId>
  <artifactId>conditional-stream</artifactId>
  <version>0.2</version>
  <type>pom</type>
</dependency>
```

#### Gradle Groovy DSL
```groovy
implementation 'com.github.kaygisiz:conditional-stream:0.2'
```

#### Gradle Kotlin DSL
```groovy
compile("com.github.kaygisiz:conditional-stream:0.2")
```

License
-------

    Copyright (C) 2019 Necati Caner Gaygisiz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[maven-central-badge]: https://img.shields.io/maven-central/v/com.github.kaygisiz/conditional-stream.svg?colorB=success&style=popout
[search-maven-artifact]: https://search.maven.org/artifact/com.github.kaygisiz/conditional-stream
[license-badge]: https://img.shields.io/badge/License-Apache%202.0-blue.svg
[license]: https://opensource.org/licenses/Apache-2.0
[latest-jar]: https://search.maven.org/remote_content?g=com.github.kaygisiz&a=conditional-stream&v=LATEST
