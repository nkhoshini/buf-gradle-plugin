package com.parmet.buf.gradle

import java.io.File

open class BufExtension {
    var configFileLocation: File? = null
    var publishSchema = false
    var previousVersion: String? = null
}