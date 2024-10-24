package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for annotations (org.jetbrains:annotations)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnnotations() { return create("annotations"); }

        /**
         * Creates a dependency provider for apacheCommons3 (org.apache.commons:commons-lang3)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApacheCommons3() { return create("apacheCommons3"); }

        /**
         * Creates a dependency provider for archunit (com.tngtech.archunit:archunit-junit5)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getArchunit() { return create("archunit"); }

        /**
         * Creates a dependency provider for archunitApi (com.tngtech.archunit:archunit-junit5-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getArchunitApi() { return create("archunitApi"); }

        /**
         * Creates a dependency provider for aspectjrt (org.aspectj:aspectjrt)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAspectjrt() { return create("aspectjrt"); }

        /**
         * Creates a dependency provider for aspectjweaver (org.aspectj:aspectjweaver)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAspectjweaver() { return create("aspectjweaver"); }

        /**
         * Creates a dependency provider for assertj (org.assertj:assertj-core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAssertj() { return create("assertj"); }

        /**
         * Creates a dependency provider for bindApi (jakarta.xml.bind:jakarta.xml.bind-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBindApi() { return create("bindApi"); }

        /**
         * Creates a dependency provider for dbScheduler (com.github.kagkarlsson:db-scheduler-spring-boot-starter)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDbScheduler() { return create("dbScheduler"); }

        /**
         * Creates a dependency provider for embeddedRedis (it.ozimov:embedded-redis)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getEmbeddedRedis() { return create("embeddedRedis"); }

        /**
         * Creates a dependency provider for feignJackson (com.netflix.feign:feign-jackson)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFeignJackson() { return create("feignJackson"); }

        /**
         * Creates a dependency provider for gson (com.google.code.gson:gson)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGson() { return create("gson"); }

        /**
         * Creates a dependency provider for hibernateTypes (com.vladmihalcea:hibernate-types-55)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHibernateTypes() { return create("hibernateTypes"); }

        /**
         * Creates a dependency provider for jackson (com.fasterxml.jackson:jackson-bom)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJackson() { return create("jackson"); }

        /**
         * Creates a dependency provider for jacksonDatabind (com.fasterxml.jackson.core:jackson-databind)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJacksonDatabind() { return create("jacksonDatabind"); }

        /**
         * Creates a dependency provider for jacksonDataformatXml (com.fasterxml.jackson.dataformat:jackson-dataformat-xml)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJacksonDataformatXml() { return create("jacksonDataformatXml"); }

        /**
         * Creates a dependency provider for jacksonDatatypeJsr310 (com.fasterxml.jackson.datatype:jackson-datatype-jsr310)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJacksonDatatypeJsr310() { return create("jacksonDatatypeJsr310"); }

        /**
         * Creates a dependency provider for javaTuples (org.javatuples:javatuples)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJavaTuples() { return create("javaTuples"); }

        /**
         * Creates a dependency provider for jaxbApi (javax.xml.bind:jaxb-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJaxbApi() { return create("jaxbApi"); }

        /**
         * Creates a dependency provider for jaxbCore (org.glassfish.jaxb:jaxb-core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJaxbCore() { return create("jaxbCore"); }

        /**
         * Creates a dependency provider for jaxbImpl (com.sun.xml.bind:jaxb-impl)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJaxbImpl() { return create("jaxbImpl"); }

        /**
         * Creates a dependency provider for jaxbXjc (com.sun.xml.bind:jaxb-xjc)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJaxbXjc() { return create("jaxbXjc"); }

        /**
         * Creates a dependency provider for jaxwsApi (javax.xml.ws:jaxws-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJaxwsApi() { return create("jaxwsApi"); }

        /**
         * Creates a dependency provider for jedis (redis.clients:jedis)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJedis() { return create("jedis"); }

        /**
         * Creates a dependency provider for json (org.json:json)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() { return create("json"); }

        /**
         * Creates a dependency provider for jsonPath (com.jayway.jsonpath:json-path)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJsonPath() { return create("jsonPath"); }

        /**
         * Creates a dependency provider for jsoup (org.jsoup:jsoup)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJsoup() { return create("jsoup"); }

        /**
         * Creates a dependency provider for junitApi (org.junit.jupiter:junit-jupiter-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunitApi() { return create("junitApi"); }

        /**
         * Creates a dependency provider for junitEngine (org.junit.jupiter:junit-jupiter-engine)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunitEngine() { return create("junitEngine"); }

        /**
         * Creates a dependency provider for junitTestContainer (org.testcontainers:junit-jupiter)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunitTestContainer() { return create("junitTestContainer"); }

        /**
         * Creates a dependency provider for jwsApi (javax.jws:javax.jws-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJwsApi() { return create("jwsApi"); }

        /**
         * Creates a dependency provider for kafka (org.springframework.kafka:spring-kafka)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKafka() { return create("kafka"); }

        /**
         * Creates a dependency provider for kafkaTest (org.springframework.kafka:spring-kafka-test)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKafkaTest() { return create("kafkaTest"); }

        /**
         * Creates a dependency provider for logstash (net.logstash.logback:logstash-logback-encoder)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLogstash() { return create("logstash"); }

        /**
         * Creates a dependency provider for lombok (org.projectlombok:lombok)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLombok() { return create("lombok"); }

        /**
         * Creates a dependency provider for mockitoInline (org.mockito:mockito-inline)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMockitoInline() { return create("mockitoInline"); }

        /**
         * Creates a dependency provider for mustache (com.github.spullara.mustache.java:compiler)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMustache() { return create("mustache"); }

        /**
         * Creates a dependency provider for ojdbc8 (com.oracle.database.jdbc:ojdbc8)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOjdbc8() { return create("ojdbc8"); }

        /**
         * Creates a dependency provider for okhttp (com.squareup.okhttp3:okhttp)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp() { return create("okhttp"); }

        /**
         * Creates a dependency provider for okhttpMockWebServer (com.squareup.okhttp3:mockwebserver)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOkhttpMockWebServer() { return create("okhttpMockWebServer"); }

        /**
         * Creates a dependency provider for opensaml (org.opensaml:opensaml)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOpensaml() { return create("opensaml"); }

        /**
         * Creates a dependency provider for openws (org.opensaml:openws)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOpenws() { return create("openws"); }

        /**
         * Creates a dependency provider for postgresTestContainer (org.testcontainers:postgresql)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPostgresTestContainer() { return create("postgresTestContainer"); }

        /**
         * Creates a dependency provider for redis (org.springframework.boot:spring-boot-starter-data-redis)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRedis() { return create("redis"); }

        /**
         * Creates a dependency provider for saajImpl (com.sun.xml.messaging.saaj:saaj-impl)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSaajImpl() { return create("saajImpl"); }

        /**
         * Creates a dependency provider for semver4j (com.vdurmont:semver4j)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSemver4j() { return create("semver4j"); }

        /**
         * Creates a dependency provider for servlet (javax.servlet:javax.servlet-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getServlet() { return create("servlet"); }

        /**
         * Creates a dependency provider for sl4j (org.slf4j:slf4j-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSl4j() { return create("sl4j"); }

        /**
         * Creates a dependency provider for sl4jSimple (org.slf4j:slf4j-simple)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSl4jSimple() { return create("sl4jSimple"); }

        /**
         * Creates a dependency provider for snakeyaml (org.yaml:snakeyaml)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSnakeyaml() { return create("snakeyaml"); }

        /**
         * Creates a dependency provider for spring (org.springframework:spring-framework-bom)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpring() { return create("spring"); }

        /**
         * Creates a dependency provider for springAutoConfigure (org.springframework.boot:spring-boot-autoconfigure)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringAutoConfigure() { return create("springAutoConfigure"); }

        /**
         * Creates a dependency provider for springBoot (org.springframework.boot:spring-boot)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringBoot() { return create("springBoot"); }

        /**
         * Creates a dependency provider for springBootTest (org.springframework.boot:spring-boot-starter-test)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringBootTest() { return create("springBootTest"); }

        /**
         * Creates a dependency provider for springCloud (org.springframework.cloud:spring-cloud-dependencies)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringCloud() { return create("springCloud"); }

        /**
         * Creates a dependency provider for springCloudNetflixHystrix (org.springframework.cloud:spring-cloud-starter-netflix-hystrix)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringCloudNetflixHystrix() { return create("springCloudNetflixHystrix"); }

        /**
         * Creates a dependency provider for springDataEnvers (org.springframework.data:spring-data-envers)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringDataEnvers() { return create("springDataEnvers"); }

        /**
         * Creates a dependency provider for springDoc (org.springdoc:springdoc-openapi-ui)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringDoc() { return create("springDoc"); }

        /**
         * Creates a dependency provider for springOauth2 (org.springframework.boot:spring-boot-starter-oauth2-resource-server)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringOauth2() { return create("springOauth2"); }

        /**
         * Creates a dependency provider for springStarterAop (org.springframework.boot:spring-boot-starter-aop)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringStarterAop() { return create("springStarterAop"); }

        /**
         * Creates a dependency provider for springStarterCache (org.springframework.boot:spring-boot-starter-cache)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringStarterCache() { return create("springStarterCache"); }

        /**
         * Creates a dependency provider for springStarterWeb (org.springframework.boot:spring-boot-starter-web)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringStarterWeb() { return create("springStarterWeb"); }

        /**
         * Creates a dependency provider for springWsCore (org.springframework.ws:spring-ws-core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpringWsCore() { return create("springWsCore"); }

        /**
         * Creates a dependency provider for wiremockJre8Standalone (com.github.tomakehurst:wiremock-jre8-standalone)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWiremockJre8Standalone() { return create("wiremockJre8Standalone"); }

        /**
         * Creates a dependency provider for woodstox (com.fasterxml.woodstox:woodstox-core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWoodstox() { return create("woodstox"); }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: annotations (23.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAnnotations() { return getVersion("annotations"); }

            /**
             * Returns the version associated to this alias: aop (1.9.7)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAop() { return getVersion("aop"); }

            /**
             * Returns the version associated to this alias: apacheCommons3 (3.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApacheCommons3() { return getVersion("apacheCommons3"); }

            /**
             * Returns the version associated to this alias: archunit (0.22.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getArchunit() { return getVersion("archunit"); }

            /**
             * Returns the version associated to this alias: assertj (3.22.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAssertj() { return getVersion("assertj"); }

            /**
             * Returns the version associated to this alias: bindApi (2.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBindApi() { return getVersion("bindApi"); }

            /**
             * Returns the version associated to this alias: dbScheduler (10.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDbScheduler() { return getVersion("dbScheduler"); }

            /**
             * Returns the version associated to this alias: docker (0.32.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDocker() { return getVersion("docker"); }

            /**
             * Returns the version associated to this alias: embeddedRedis (0.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEmbeddedRedis() { return getVersion("embeddedRedis"); }

            /**
             * Returns the version associated to this alias: feignJackson (8.18.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFeignJackson() { return getVersion("feignJackson"); }

            /**
             * Returns the version associated to this alias: gitProperties (2.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGitProperties() { return getVersion("gitProperties"); }

            /**
             * Returns the version associated to this alias: gson (2.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGson() { return getVersion("gson"); }

            /**
             * Returns the version associated to this alias: hibernateTypes (2.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHibernateTypes() { return getVersion("hibernateTypes"); }

            /**
             * Returns the version associated to this alias: jackson (2.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJackson() { return getVersion("jackson"); }

            /**
             * Returns the version associated to this alias: jacksonDatabind (2.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJacksonDatabind() { return getVersion("jacksonDatabind"); }

            /**
             * Returns the version associated to this alias: jacksonDataformatXml (2.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJacksonDataformatXml() { return getVersion("jacksonDataformatXml"); }

            /**
             * Returns the version associated to this alias: jacksonDatatypeJsr310 (2.13.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJacksonDatatypeJsr310() { return getVersion("jacksonDatatypeJsr310"); }

            /**
             * Returns the version associated to this alias: java (17)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJava() { return getVersion("java"); }

            /**
             * Returns the version associated to this alias: javaTuples (1.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJavaTuples() { return getVersion("javaTuples"); }

            /**
             * Returns the version associated to this alias: jaxb (2.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJaxb() { return getVersion("jaxb"); }

            /**
             * Returns the version associated to this alias: jaxbCore (2.3.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJaxbCore() { return getVersion("jaxbCore"); }

            /**
             * Returns the version associated to this alias: jaxwsApi (2.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJaxwsApi() { return getVersion("jaxwsApi"); }

            /**
             * Returns the version associated to this alias: jedis (3.7.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJedis() { return getVersion("jedis"); }

            /**
             * Returns the version associated to this alias: json (20180813)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJson() { return getVersion("json"); }

            /**
             * Returns the version associated to this alias: jsonPath (2.7.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJsonPath() { return getVersion("jsonPath"); }

            /**
             * Returns the version associated to this alias: jsoup (1.15.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJsoup() { return getVersion("jsoup"); }

            /**
             * Returns the version associated to this alias: junit (5.8.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

            /**
             * Returns the version associated to this alias: jwsApi (1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJwsApi() { return getVersion("jwsApi"); }

            /**
             * Returns the version associated to this alias: kafka (2.8.7)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKafka() { return getVersion("kafka"); }

            /**
             * Returns the version associated to this alias: logstash (7.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLogstash() { return getVersion("logstash"); }

            /**
             * Returns the version associated to this alias: lombok (1.18.22)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLombok() { return getVersion("lombok"); }

            /**
             * Returns the version associated to this alias: mockitoInline (4.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMockitoInline() { return getVersion("mockitoInline"); }

            /**
             * Returns the version associated to this alias: mustache (0.9.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMustache() { return getVersion("mustache"); }

            /**
             * Returns the version associated to this alias: ojdbc8 (12.2.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOjdbc8() { return getVersion("ojdbc8"); }

            /**
             * Returns the version associated to this alias: okhttp (4.9.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOkhttp() { return getVersion("okhttp"); }

            /**
             * Returns the version associated to this alias: opensaml (2.6.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOpensaml() { return getVersion("opensaml"); }

            /**
             * Returns the version associated to this alias: openws (1.5.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOpenws() { return getVersion("openws"); }

            /**
             * Returns the version associated to this alias: saajImpl (1.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSaajImpl() { return getVersion("saajImpl"); }

            /**
             * Returns the version associated to this alias: semver4j (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSemver4j() { return getVersion("semver4j"); }

            /**
             * Returns the version associated to this alias: servlet (4.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getServlet() { return getVersion("servlet"); }

            /**
             * Returns the version associated to this alias: sl4j (1.7.35)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSl4j() { return getVersion("sl4j"); }

            /**
             * Returns the version associated to this alias: snakeyaml (1.33)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSnakeyaml() { return getVersion("snakeyaml"); }

            /**
             * Returns the version associated to this alias: sonarqube (3.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSonarqube() { return getVersion("sonarqube"); }

            /**
             * Returns the version associated to this alias: spring (5.3.21)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpring() { return getVersion("spring"); }

            /**
             * Returns the version associated to this alias: springBoot (2.7.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpringBoot() { return getVersion("springBoot"); }

            /**
             * Returns the version associated to this alias: springCloud (2021.0.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpringCloud() { return getVersion("springCloud"); }

            /**
             * Returns the version associated to this alias: springCloudNetflixHystrix (2.2.10.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpringCloudNetflixHystrix() { return getVersion("springCloudNetflixHystrix"); }

            /**
             * Returns the version associated to this alias: springDataEnvers (2.7.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpringDataEnvers() { return getVersion("springDataEnvers"); }

            /**
             * Returns the version associated to this alias: springDependencyManagement (1.0.11.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpringDependencyManagement() { return getVersion("springDependencyManagement"); }

            /**
             * Returns the version associated to this alias: springDoc (1.6.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpringDoc() { return getVersion("springDoc"); }

            /**
             * Returns the version associated to this alias: springWsCore (3.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpringWsCore() { return getVersion("springWsCore"); }

            /**
             * Returns the version associated to this alias: testContainers (1.16.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTestContainers() { return getVersion("testContainers"); }

            /**
             * Returns the version associated to this alias: wiremockJre8Standalone (2.32.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWiremockJre8Standalone() { return getVersion("wiremockJre8Standalone"); }

            /**
             * Returns the version associated to this alias: woodstox (6.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWoodstox() { return getVersion("woodstox"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for aopDeps which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.aspectj:aspectjweaver</li>
             *    <li>org.aspectj:aspectjrt</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getAopDeps() { return createBundle("aopDeps"); }

            /**
             * Creates a dependency bundle provider for jaxb which is an aggregate for the following dependencies:
             * <ul>
             *    <li>javax.xml.bind:jaxb-api</li>
             *    <li>org.glassfish.jaxb:jaxb-core</li>
             *    <li>com.sun.xml.bind:jaxb-impl</li>
             *    <li>com.sun.xml.bind:jaxb-xjc</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getJaxb() { return createBundle("jaxb"); }

            /**
             * Creates a dependency bundle provider for jaxws which is an aggregate for the following dependencies:
             * <ul>
             *    <li>javax.xml.ws:jaxws-api</li>
             *    <li>javax.jws:javax.jws-api</li>
             *    <li>com.sun.xml.messaging.saaj:saaj-impl</li>
             *    <li>jakarta.xml.bind:jakarta.xml.bind-api</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getJaxws() { return createBundle("jaxws"); }

            /**
             * Creates a dependency bundle provider for testContainerDeps which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.testcontainers:postgresql</li>
             *    <li>org.testcontainers:junit-jupiter</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getTestContainerDeps() { return createBundle("testContainerDeps"); }

            /**
             * Creates a dependency bundle provider for testSpringBootDeps which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.assertj:assertj-core</li>
             *    <li>org.springframework.boot:spring-boot-starter-test</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getTestSpringBootDeps() { return createBundle("testSpringBootDeps"); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for docker to the plugin id 'com.palantir.docker'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getDocker() { return createPlugin("docker"); }

            /**
             * Creates a plugin provider for gitProperties to the plugin id 'com.gorylenko.gradle-git-properties'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getGitProperties() { return createPlugin("gitProperties"); }

            /**
             * Creates a plugin provider for sonarqube to the plugin id 'org.sonarqube'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSonarqube() { return createPlugin("sonarqube"); }

            /**
             * Creates a plugin provider for springBoot to the plugin id 'org.springframework.boot'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSpringBoot() { return createPlugin("springBoot"); }

            /**
             * Creates a plugin provider for springDependencyManagement to the plugin id 'io.spring.dependency-management'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSpringDependencyManagement() { return createPlugin("springDependencyManagement"); }

    }

}
