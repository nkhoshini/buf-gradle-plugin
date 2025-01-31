/*
 * Copyright (c) 2022 Andrew Parmet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.parmet.buf.gradle

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByName

const val BUF_EXTENSION_NAME = "buf"

internal fun Project.createExtension() {
    extensions.create<BufExtension>(BUF_EXTENSION_NAME)
}

internal fun Project.getExtension() =
    extensions.getByName<BufExtension>(BUF_EXTENSION_NAME)

internal fun Task.getExtension() =
    project.getExtension()

internal fun Project.runBreakageCheck() =
    with(getExtension()) {
        checkSchemaAgainstLatestRelease || previousVersion != null
    }

internal fun Project.publishSchema() =
    getExtension().publishSchema
