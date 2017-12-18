/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.sdk.io.common;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.Validation;
import org.apache.beam.sdk.testing.TestPipelineOptions;

/**
 * This shared set of options is used so that the full suite of IO tests can be run in one pass -
 * if a test tries to read TestPipelineOptions, it must be able to understand all the options
 * that were passed on the command line.
 */
public interface IOTestPipelineOptions extends TestPipelineOptions {
  /* Postgres */
  @Description("Server name for postgres server (host name/ip address)")
  @Default.String("postgres-server-name")
  String getPostgresServerName();
  void setPostgresServerName(String value);

  @Description("Username for postgres server")
  @Default.String("postgres-username")
  String getPostgresUsername();
  void setPostgresUsername(String value);

  // Note that passwords are not as secure an authentication as other methods, and used here for
  // a test environment only.
  @Description("Password for postgres server")
  @Default.String("postgres-password")
  String getPostgresPassword();
  void setPostgresPassword(String value);

  @Description("Database name for postgres server")
  @Default.String("postgres-database-name")
  String getPostgresDatabaseName();
  void setPostgresDatabaseName(String value);

  @Description("Port for postgres server")
  @Default.Integer(0)
  Integer getPostgresPort();
  void setPostgresPort(Integer value);

  @Description("Whether the postgres server uses SSL")
  @Default.Boolean(true)
  Boolean getPostgresSsl();
  void setPostgresSsl(Boolean value);

  /* Elasticsearch */
  @Description("Server name for Elasticsearch server (host name/ip address)")
  @Default.String("elasticsearch-server-name")
  String getElasticsearchServer();
  void setElasticsearchServer(String value);

  @Description("Http port for elasticsearch server")
  @Default.Integer(9200)
  Integer getElasticsearchHttpPort();
  void setElasticsearchHttpPort(Integer value);

  /* Solr */
  @Description("Address of Zookeeper server for Solr")
  @Default.String("zookeeper-server")
  String getSolrZookeeperServer();
  void setSolrZookeeperServer(String value);

  /* Cassandra */
  @Description("Host for Cassandra server (host name/ip address)")
  @Default.String("cassandra-host")
  String getCassandraHost();
  void setCassandraHost(String host);

  @Description("Port for Cassandra server")
  @Default.Integer(7001)
  Integer getCassandraPort();
  void setCassandraPort(Integer port);

  /* Options for test pipeline for file-based I/O in 'sdks/java/io/file-based-io-tests/'. */
  @Description("Number records that will be written and read by the test")
  @Default.Long(100000)
  Long getNumberOfRecords();

  void setNumberOfRecords(Long count);

  @Description("Destination prefix for files generated by the test")
  @Validation.Required
  String getFilenamePrefix();

  void setFilenamePrefix(String prefix);

  @Description("File compression type for writing and reading test files")
  @Default.String("UNCOMPRESSED")
  String getCompressionType();

  void setCompressionType(String compressionType);
}
