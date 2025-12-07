plugins {
    application
    id("com.gradleup.shadow") version "8.3.1"
    checkstyle
}

checkstyle {
    configFile = rootProject.file("config/checkstyle/checkstyle.xml")
    toolVersion = "12.2.0"
}

application.mainClass = "com.glados.bot.BotApplication"

group = "org.glados"
version = "1.0"

val jdaVersion = "6.1.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:$jdaVersion")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("ch.qos.logback:logback-classic:1.4.14")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.isIncremental = true
    sourceCompatibility = "21"
}