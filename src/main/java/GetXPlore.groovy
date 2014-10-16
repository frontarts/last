/**
 * Created by IntelliJ IDEA. @5/29/14 12:37 PM
 * Author: wangy23
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
def fileList = []
def targetVersion = ''

File file = new File('//10.32.112.200/qexpl/JianL/Builds/xPloreBuilds/1.5')
file.list().each { if (it.startsWith("1")) fileList << it }
fileList = fileList.sort()
println "${fileList.size} builds in folder"
def folder
if (targetVersion != null || targetVersion != '') {
    fileList = fileList.grep(~/.*${targetVersion}.*/)
    if (fileList.size() != 0) {
        folder = fileList.last()
    } else {
        println 'No target version found.'
        folder = fileList[fileList.size - 1]
    }
} else {
    folder = fileList[fileList.size - 1]
}
// check the build version of last downloading,
File versionFile = new File('C:/xPlore.version')
def lastVersion='';
if (versionFile.exists()) {
    versionFile.eachLine { line -> lastVersion = line }
    println "last version is: ${lastVersion}"

}

println "downloading build from folder: " +folder
def matcher = folder =~ /\d{4}/
def version = matcher[1]
println "new minor version is: ${version}"
if (lastVersion < version) {
    versionFile.delete()
    versionFile << version
    new AntBuilder().copy(todir: "C:/builds") {
        fileset(dir: "//10.32.112.200/qexpl/JianL/Builds/xPloreBuilds/1.5/" + folder) {
            include(name: "win64/**")
            include(name: "dsearch-sdk.zip")
        }
    }
} else {
    println "no new build is available now"
}
