object HibernateVersion {
    const val reactiveCore = "1.0.0.Alpha11"
    const val types = "2.10.0"
    const val hibernate = "5.4.22.Final"
}

object HibernateLibs {
    const val reactiveCore = "org.hibernate.reactive:hibernate-reactive-core:${HibernateVersion.reactiveCore}"
    const val types = "com.vladmihalcea:hibernate-types-52:${HibernateVersion.types}"
    const val spatial = "org.hibernate:hibernate-spatial:${HibernateVersion.hibernate}"
}