/*
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: Deployment.java,v 1.1 2005/11/14 22:25:59 khussey Exp $
 */
package org.eclipse.uml2.uml;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * In the metamodel, Deployment is a subtype of Dependency.
 * A component deployment is the deployment of one or more artifacts or artifact instances to a deployment target, optionally parameterized by a deployment specification. Examples are executables and configuration files.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Deployment#getDeployedArtifacts <em>Deployed Artifact</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Deployment#getConfigurations <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Deployment#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getDeployment()
 * @model
 * @generated
 */
public interface Deployment
		extends Dependency {

	/**
	 * Returns the value of the '<em><b>Deployed Artifact</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.DeployedArtifact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Artifacts that are deployed onto a Node. This association specializes the supplier association.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deployed Artifact</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getDeployment_DeployedArtifact()
	 * @model type="org.eclipse.uml2.uml.DeployedArtifact" ordered="false"
	 * @generated
	 */
	List getDeployedArtifacts();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.DeployedArtifact} with the specified '<em><b>Name</b></em>' from the '<em><b>Deployed Artifact</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.DeployedArtifact} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.DeployedArtifact} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getDeployedArtifacts()
	 * @generated
	 */
	DeployedArtifact getDeployedArtifact(String name);

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.DeploymentSpecification}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.DeploymentSpecification#getDeployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specification of properties that parameterize the deployment and execution of one or more Artifacts. This association is specialized from the ownedMember association.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getDeployment_Configuration()
	 * @see org.eclipse.uml2.uml.DeploymentSpecification#getDeployment
	 * @model type="org.eclipse.uml2.uml.DeploymentSpecification" opposite="deployment" containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	List getConfigurations();

	/**
	 * Creates a {@link org.eclipse.uml2.uml.DeploymentSpecification} and appends it to the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.DeploymentSpecification}.
	 * @see #getConfigurations()
	 * @generated
	 */
	DeploymentSpecification createConfiguration();

	/**
	 * Retrieves the {@link org.eclipse.uml2.uml.DeploymentSpecification} with the specified '<em><b>Name</b></em>' from the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.DeploymentSpecification} to retrieve.
	 * @return The {@link org.eclipse.uml2.uml.DeploymentSpecification} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getConfigurations()
	 * @generated
	 */
	DeploymentSpecification getConfiguration(String name);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.DeploymentTarget#getDeployments <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The DeployedTarget which is the target of a Deployment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Location</em>' container reference.
	 * @see #setLocation(DeploymentTarget)
	 * @see org.eclipse.uml2.uml.UMLPackage#getDeployment_Location()
	 * @see org.eclipse.uml2.uml.DeploymentTarget#getDeployments
	 * @model opposite="deployment" required="true" ordered="false"
	 * @generated
	 */
	DeploymentTarget getLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Deployment#getLocation <em>Location</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' container reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(DeploymentTarget value);

} // Deployment