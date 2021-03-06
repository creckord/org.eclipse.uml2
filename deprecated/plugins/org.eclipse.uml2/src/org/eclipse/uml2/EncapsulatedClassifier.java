/*
 * Copyright (c) 2003, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: EncapsulatedClassifier.java,v 1.13 2006/05/26 18:16:51 khussey Exp $
 */
package org.eclipse.uml2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Encapsulated Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Extends a classifier with the ability to own ports as specific and type checked interaction points. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.EncapsulatedClassifier#getOwnedPorts <em>Owned Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.UML2Package#getEncapsulatedClassifier()
 * @model abstract="true"
 * @generated
 */
public interface EncapsulatedClassifier extends StructuredClassifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Owned Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References a set of ports that an encapsulated classifier owns. (Subsets Classifier.feature and Namespace.ownedMember.)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Port</em>' containment reference list.
	 * @see org.eclipse.uml2.UML2Package#getEncapsulatedClassifier_OwnedPort()
	 * @model type="org.eclipse.uml2.Port" containment="true" ordered="false"
	 * @generated
	 */
	EList getOwnedPorts();


	/**
	 * Retrieves the first {@link org.eclipse.uml2.Port} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.Port} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.Port} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedPorts()
	 * @generated
	 */
    Port getOwnedPort(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.Port} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.Port} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.Port} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedPorts()
	 * @generated
	 */
	Port getOwnedPort(String name, boolean ignoreCase);


    /**
     * Creates a {@link org.eclipse.uml2.Port} and appends it to the '<em><b>Owned Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.Port} to create.
	 * @return The new {@link org.eclipse.uml2.Port}.
	 * @see #getOwnedPorts()
	 * @generated NOT
	 * @deprecated Use #createOwnedPort() instead.
     */
    Port createOwnedPort(EClass eClass);

	/**
	 * Creates a {@link org.eclipse.uml2.Port} and appends it to the '<em><b>Owned Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.Port}.
	 * @see #getOwnedPorts()
	 * @generated NOT
	 */
    Port createOwnedPort();

} // EncapsulatedClassifier
