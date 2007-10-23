/*
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: PackageMerge.java,v 1.7 2007/10/23 15:54:21 jbruck Exp $
 */
package org.eclipse.uml2.uml;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Merge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A package merge defines how the contents of one package are extended by the contents of another package.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.PackageMerge#getMergedPackage <em>Merged Package</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.PackageMerge#getReceivingPackage <em>Receiving Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getPackageMerge()
 * @model
 * @generated
 */
public interface PackageMerge
		extends DirectedRelationship {

	/**
	 * Returns the value of the '<em><b>Merged Package</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.eclipse.uml2.uml.DirectedRelationship#getTargets() <em>Target</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the Package that is to be merged with the receiving package of the PackageMerge.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Merged Package</em>' reference.
	 * @see #setMergedPackage(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.uml2.uml.UMLPackage#getPackageMerge_MergedPackage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getMergedPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.PackageMerge#getMergedPackage <em>Merged Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Merged Package</em>' reference.
	 * @see #getMergedPackage()
	 * @generated
	 */
	void setMergedPackage(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Receiving Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.Package#getPackageMerges <em>Package Merge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.eclipse.uml2.uml.DirectedRelationship#getSources() <em>Source</em>}'</li>
	 *   <li>'{@link org.eclipse.uml2.uml.Element#getOwner() <em>Owner</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the Package that is being extended with the contents of the merged package of the PackageMerge.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Receiving Package</em>' container reference.
	 * @see #setReceivingPackage(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.uml2.uml.UMLPackage#getPackageMerge_ReceivingPackage()
	 * @see org.eclipse.uml2.uml.Package#getPackageMerges
	 * @model opposite="packageMerge" required="true" transient="false" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getReceivingPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.PackageMerge#getReceivingPackage <em>Receiving Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiving Package</em>' container reference.
	 * @see #getReceivingPackage()
	 * @generated
	 */
	void setReceivingPackage(org.eclipse.uml2.uml.Package value);

} // PackageMerge
