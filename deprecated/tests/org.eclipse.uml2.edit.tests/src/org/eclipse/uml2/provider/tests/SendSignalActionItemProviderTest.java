/*
 * Copyright (c) 2003, 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: SendSignalActionItemProviderTest.java,v 1.4 2005/05/18 17:04:08 khussey Exp $
 */
package org.eclipse.uml2.provider.tests;

import junit.textui.TestRunner;

import org.eclipse.uml2.SendSignalAction;
import org.eclipse.uml2.UML2Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the '<em><b>Send Signal Action</b></em>' item provider adapter.
 * <!-- end-user-doc -->
 * @generated
 */
public class SendSignalActionItemProviderTest extends InvocationActionItemProviderTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SendSignalActionItemProviderTest.class);
	}

	/**
	 * Constructs a new Send Signal Action item provider adapter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendSignalActionItemProviderTest(String name) {
		super(name);
	}

	/**
	 * Returns the model object for this Send Signal Action item provider adapter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SendSignalAction getModelObject() {
		return (SendSignalAction) modelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		super.setUp();

		setModelObject(UML2Factory.eINSTANCE.createSendSignalAction());
	}

} //SendSignalActionItemProviderTest
