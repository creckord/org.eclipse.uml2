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
 * $Id: StartOwnedBehaviorActionTest.java,v 1.1 2005/04/04 20:06:06 khussey Exp $
 */
package org.eclipse.uml2.tests;

import junit.textui.TestRunner;

import org.eclipse.uml2.StartOwnedBehaviorAction;
import org.eclipse.uml2.UML2Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Start Owned Behavior Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.StartOwnedBehaviorAction#getInputs() <em>Get Inputs</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class StartOwnedBehaviorActionTest extends ActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2003, 2005 IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StartOwnedBehaviorActionTest.class);
	}

	/**
	 * Constructs a new Start Owned Behavior Action test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartOwnedBehaviorActionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Start Owned Behavior Action test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private StartOwnedBehaviorAction getFixture() {
		return (StartOwnedBehaviorAction)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(UML2Factory.eINSTANCE.createStartOwnedBehaviorAction());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.StartOwnedBehaviorAction#getInputs() <em>Get Inputs</em>}' getter operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.StartOwnedBehaviorAction#getInputs()
	 * @generated
	 */
	public void testGetInputsGen() {
		// TODO: implement this getter operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	public void testGetInputs() {
		testGetInputsGen();
		
		super.testGetInputs();

		assertTrue(getFixture().getInputs().contains(getFixture().getObject()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.uml2.impl.tests.ActionImplTest#setUpInputs()
	 */
	protected void setUpInputs() {
		super.setUpInputs();

		getFixture().setObject(UML2Factory.eINSTANCE.createInputPin());
	}

} //StartOwnedBehaviorActionImplTest