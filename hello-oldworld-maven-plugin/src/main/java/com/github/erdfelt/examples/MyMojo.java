package com.github.erdfelt.examples;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

/**
 * Goal which shows the project details
 *
 * @goal info
 * 
 * @phase validate
 */
public class MyMojo
    extends AbstractMojo
{
    /**
     * Example of the maven project itself
     * 
     * @parameter default-value="${project}"
     * @required
     */
    private MavenProject project;
    
    /**
     * Example of a plugin configured output directory
     * 
     * @parameter expression="outputDir" default-value="${project.build.directory}"
     * @required
     */
    private File outputDirectory;

    public void execute()
        throws MojoExecutionException
    {
        getLog().info("Your Project: " + project.getId());
        
        getLog().info("Your output directory (for this plugin) is: " + outputDirectory.getAbsolutePath());
    }
}
