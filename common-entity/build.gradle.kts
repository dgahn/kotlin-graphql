import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.ofSourceSet
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

apply(plugin=GrpcPlugin.protobuf)

configurations.forEach {
    if (it.name.toLowerCase().contains("proto")) {
        it.attributes.attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage::class.java, "java-runtime"))
    }
}

dependencies {
    compileOnly(JavaLibs.javax)

    api(GrpcLibs.protobufJava)
    api(GrpcLibs.protobufJavaUtil)
    api(GrpcLibs.grpcKotlinStub)
    api(GrpcLibs.grpcStub)
    api(GrpcLibs.grpcProtobuf)
    api(GrpcLibs.grpcNettyShaded)
    implementation(kotlin("stdlib-jdk8"))
}

protobuf {
    generatedFilesBaseDir = "$projectDir/build/generated/source"
    protoc {
        artifact = GrpcArtifact.protoc
    }
    plugins {
        id(GrpcPlugin.grpc) {
            artifact = GrpcArtifact.protocGenGrpcJava
        }
        id(GrpcPlugin.grpcKt) {
            artifact = GrpcArtifact.protocGenGrpcKt
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach { task ->
            task.plugins {
                id(GrpcPlugin.grpc)
                id(GrpcPlugin.grpcKt)
            }
            task.generateDescriptorSet = true
            task.descriptorSetOptions.includeSourceInfo = true
            task.descriptorSetOptions.includeImports = true
        }

    }
}

sourceSets {
    main {
        java {
            srcDir("build/generated/source/main/java")
            srcDir("build/generated/source/main/grpc")
            srcDir("build/generated/source/main/grpckt")
        }
    }
}
