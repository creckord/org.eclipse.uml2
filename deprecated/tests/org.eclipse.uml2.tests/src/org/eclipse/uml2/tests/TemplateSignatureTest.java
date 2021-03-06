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
 * $Id: TemplateSignatureTest.java,v 1.3 2006/05/29 17:27:34 khussey Exp $
 */
package org.eclipse.uml2.tests;

import java.util.Iterator;

import junit.textui.TestRunner;

import org.eclipse.uml2.TemplateSignature;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.TemplateParameter;
import org.eclipse.uml2.UML2Factory;
import org.eclipse.uml2.UML2Package;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Template Signature</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplateSignatureTest extends ElementTest {

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
		TestRunner.run(TemplateSignatureTest.class);
	}

	/**
	 * Constructs a new Template Signature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignatureTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Template Signature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TemplateSignature getFixture() {
		return (TemplateSignature)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(UML2Factory.eINSTANCE.createTemplateSignature());
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


	public void testGetParameters() {

		for (Iterator eAllSubClasses = getEAllSubClasses(UML2Package.eINSTANCE.getTemplateParameter()).iterator(); eAllSubClasses.hasNext();) {
			TemplateParameter templateParameter = (TemplateParameter) UML2Factory.eINSTANCE.create((EClass) eAllSubClasses.next());

			getFixture().getOwnedParameters().add(templateParameter);

			getFixture().getParameters().remove(templateParameter);

			assertFalse(getFixture().getParameters().contains(templateParameter));
			assertFalse(getFixture().getOwnedParameters().contains(templateParameter));

			getFixture().getParameters().add(templateParameter);

			assertTrue(getFixture().getParameters().contains(templateParameter));
			assertFalse(getFixture().getOwnedParameters().contains(templateParameter));
		}
	}

	public void testGetOwnedParameters() {

		for (Iterator eAllSubClasses = getEAllSubClasses(UML2Package.eINSTANCE.getTemplateParameter()).iterator(); eAllSubClasses.hasNext();) {
			TemplateParameter templateParameter = (TemplateParameter) UML2Factory.eINSTANCE.create((EClass) eAllSubClasses.next());

			getFixture().getOwnedParameters().add(templateParameter);

			assertTrue(getFixture().getOwnedParameters().contains(templateParameter));
			assertTrue(getFixture().getParameters().contains(templateParameter));

			getFixture().getOwnedParameters().remove(templateParameter);

			assertFalse(getFixture().getOwnedParameters().contains(templateParameter));
			assertTrue(getFixture().getParameters().contains(templateParameter));
		}
	}

	public void testGetOwnedElements() {
		super.testGetOwnedElements();

		assertTrue(getFixture().getOwnedElements().containsAll(getFixture().getOwnedParameters()));
	}

	public void testGetOwner() {
		super.testGetOwner();

		assertSame(getFixture().getTemplate(), getFixture().getOwner());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.uml2.impl.tests.ElementImplTest#setUpOwner()
	 */
	protected void setUpOwner() {
		UML2Factory.eINSTANCE.createComment().setOwnedTemplateSignature(getFixture());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.uml2.impl.tests.ElementImplTest#setUpOwnedElements()
	 */
	protected void setUpOwnedElements() {
		super.setUpOwnedElements();

		getFixture().getOwnedParameters().add(UML2Factory.eINSTANCE.createTemplateParameter());
		getFixture().getOwnedParameters().add(UML2Factory.eINSTANCE.createTemplateParameter());
	}

} //TemplateSignatureImplTest
