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
 * $Id: Enumeration.java,v 1.13 2006/05/26 18:16:52 khussey Exp $
 */
package org.eclipse.uml2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Enumeration is a kind of data type, whose instances may be any of a number of user-defined enumeration literals. It is possible to extend the set of applicable enumeration literals in other packages or profiles. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.Enumeration#getOwnedLiterals <em>Owned Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.UML2Package#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends DataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Owned Literal</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.EnumerationLiteral}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.EnumerationLiteral#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Literal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ordered set of literals for this Enumeration. Subsets Element::ownedMember.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Literal</em>' containment reference list.
	 * @see org.eclipse.uml2.UML2Package#getEnumeration_OwnedLiteral()
	 * @see org.eclipse.uml2.EnumerationLiteral#getEnumeration
	 * @model type="org.eclipse.uml2.EnumerationLiteral" opposite="enumeration" containment="true"
	 * @generated
	 */
	EList getOwnedLiterals();


	/**
	 * Retrieves the first {@link org.eclipse.uml2.EnumerationLiteral} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.EnumerationLiteral} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.EnumerationLiteral} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedLiterals()
	 * @generated
	 */
    EnumerationLiteral getOwnedLiteral(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.EnumerationLiteral} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.EnumerationLiteral} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.EnumerationLiteral} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedLiterals()
	 * @generated
	 */
	EnumerationLiteral getOwnedLiteral(String name, boolean ignoreCase);


    /**
     * Creates a {@link org.eclipse.uml2.EnumerationLiteral} and appends it to the '<em><b>Owned Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.EnumerationLiteral} to create.
	 * @return The new {@link org.eclipse.uml2.EnumerationLiteral}.
	 * @see #getOwnedLiterals()
	 * @generated NOT
	 * @deprecated Use #createOwnedLiteral() instead.
     */
    EnumerationLiteral createOwnedLiteral(EClass eClass);

	/**
	 * Creates a {@link org.eclipse.uml2.EnumerationLiteral} and appends it to the '<em><b>Owned Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.EnumerationLiteral}.
	 * @see #getOwnedLiterals()
	 * @generated NOT
	 */
    EnumerationLiteral createOwnedLiteral();

	// <!-- begin-custom-operations -->

	/**
	 * Creates an enumeration literal with the specified name as an owned
	 * literal of this enumeration.
	 * 
	 * @param name
	 *            The name for the owned literal.
	 * @return The new enumeration literal.
	 * @exception IllegalArgumentException
	 *                If the name is empty.
	 */
	EnumerationLiteral createOwnedLiteral(String name);

	// <!-- end-custom-operations -->

} // Enumeration
