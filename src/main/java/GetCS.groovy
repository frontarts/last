/**
 * Created by IntelliJ IDEA. @5/29/14 12:37 PM
 * Author: wangy23
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
def fileList = []
def targetVersion = ''

File file = new File('//iigshfs.lss.emc.com/qexpl/JianL/Builds/CSBuilds/7.1SP1')
file.list().each { if (it.startsWith("7")) fileList << it }
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
File versionFile = new File('C:/cs.version')
def lastVersion = '';
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
        fileset(dir: "//iigshfs.lss.emc.com/qexpl/JianL/Builds/CSBuilds/7.1SP1/" + folder + "/Server") {
            include(name: "win64_sql/**")
        }
    }
} else {
    println "no new build is available now"
}
