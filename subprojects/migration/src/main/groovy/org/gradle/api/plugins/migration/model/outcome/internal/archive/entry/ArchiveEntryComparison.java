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

package org.gradle.api.plugins.migration.model.outcome.internal.archive.entry;

import org.gradle.api.plugins.migration.model.compare.internal.ComparisonResultType;

public class ArchiveEntryComparison {

    private final String path;
    private final ArchiveEntry from;
    private final ArchiveEntry to;

    public ArchiveEntryComparison(String path, ArchiveEntry from, ArchiveEntry to) {
        if (from == null && to == null) {
            throw new IllegalArgumentException("Both 'from' and 'to' cannot be null");
        }

        this.path = path;
        this.from = from;
        this.to = to;
    }

    public ComparisonResultType getComparisonResultType() {
        if (from != null && to == null) {
            return ComparisonResultType.FROM_ONLY;
        } else if (from == null && to != null) {
            return ComparisonResultType.TO_ONLY;
        } else {
            //noinspection ConstantConditions
            return from.equals(to) ? ComparisonResultType.EQUAL : ComparisonResultType.UNEQUAL;
        }
    }

    public String getPath() {
        return path;
    }

    public ArchiveEntry getFrom() {
        return from;
    }

    public ArchiveEntry getTo() {
        return to;
    }
}