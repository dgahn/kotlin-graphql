apply(plugin=GrpcPlugin.protobuf)

configurations.forEach {
    if (it.name.toLowerCase().contains("proto")) {
        it.attributes.attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage::class.java, "java-runtime"))
    }
}

dependencies {
    compileOnly(JavaLibs.javax)

    implementation(GrpcLibs.protobufJava)
    implementation(GrpcLibs.protobufJavaUtil)
    implementation(GrpcLibs.grpcKotlinStub)
    implementation(GrpcLibs.grpcStub)
    implementation(GrpcLibs.grpcProtobuf)
    implementation(GrpcLibs.grpcNettyShaded)
}

protobuf {
    generatedFilesBaseDir = "$projectDir/build/generated/source"
    protoc {
        artifact = "com.google.protobuf:protoc:$protocVersion"
    }
    plugins {
        id(GrpcPlugin.grpc) {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpcKotlinVersion"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach { task ->
            task.plugins {
                id("grpc")
                id("grpckt")
            }
            task.generateDescriptorSet = true
            task.descriptorSetOptions.includeSourceInfo = true
            task.descriptorSetOptions.includeImports = true
            task.descriptorSetOptions.path =
                "${buildDir}/resources/META-INF/armeria/grpc/service-name.dsc"
        }

    }
}

sourceSets {
    main {
        java.srcDir("build/generated/source/main/java")
        java.srcDir("build/generated/source/main/grpc")
        java.srcDir("build/generated/source/main/grpckt")
    }
}