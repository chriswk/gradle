/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.publish.maven.internal.artifact;

import org.gradle.api.publish.maven.MavenArtifact;

abstract class ConfigurableMavenArtifact implements MavenArtifact {
    private String extension;
    private String classifier;

    protected abstract String getBaseClassifier();
    protected abstract String getBaseExtension();

    public String getExtension() {
        return extension == null ? getBaseExtension() : extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getClassifier() {
        return classifier == null ? getBaseClassifier() : classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }
}
