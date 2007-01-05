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
 * $Id: PropertyTest.java,v 1.10 2007/01/05 21:48:58 khussey Exp $
 */
package org.eclipse.uml2.uml.tests;

import junit.textui.TestRunner;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.DeploymentTarget#getDeployedElements() <em>Deployed Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#getClass_() <em>Class</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#getDefault() <em>Default</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#isComposite() <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#getOpposite() <em>Opposite</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Property#isCompatibleWith(org.eclipse.uml2.uml.ParameterableElement) <em>Is Compatible With</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.ParameterableElement#isTemplateParameter() <em>Is Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.TemplateableElement#parameterableElements() <em>Parameterable Elements</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.TemplateableElement#isTemplate() <em>Is Template</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateMultiplicityOfComposite(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Multiplicity Of Composite</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateSubsettingContextConforms(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Subsetting Context Conforms</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateRedefinedPropertyInherited(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Redefined Property Inherited</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateSubsettingRules(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Subsetting Rules</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateNavigableReadonly(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Navigable Readonly</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateDerivedUnionIsDerived(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Derived Union Is Derived</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateDerivedUnionIsReadOnly(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Derived Union Is Read Only</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateSubsettedPropertyNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Subsetted Property Names</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateDeploymentTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Deployment Target</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#validateBindingToAttribute(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Binding To Attribute</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#setIsNavigable(boolean) <em>Set Is Navigable</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#getOtherEnd() <em>Get Other End</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#setBooleanDefaultValue(boolean) <em>Set Boolean Default Value</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#setIntegerDefaultValue(int) <em>Set Integer Default Value</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#setStringDefaultValue(java.lang.String) <em>Set String Default Value</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#setUnlimitedNaturalDefaultValue(int) <em>Set Unlimited Natural Default Value</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#setNullDefaultValue() <em>Set Null Default Value</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#isAttribute(org.eclipse.uml2.uml.Property) <em>Is Attribute</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#subsettingContext() <em>Subsetting Context</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#isNavigable() <em>Is Navigable</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Property#isConsistentWith(org.eclipse.uml2.uml.RedefinableElement) <em>Is Consistent With</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PropertyTest
		extends StructuralFeatureTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PropertyTest.class);
	}

	/**
	 * Constructs a new Property test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Property test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Property getFixture() {
		return (Property) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp()
			throws Exception {
		setFixture(UMLFactory.eINSTANCE.createProperty());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown()
			throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.DeploymentTarget#getDeployedElements() <em>Deployed Element</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.DeploymentTarget#getDeployedElements()
	 * @generated
	 */
	public void testGetDeployedElements() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#getDefault() <em>Default</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#getDefault()
	 * @generated
	 */
	public void testGetDefault() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setDefault(java.lang.String) <em>Default</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setDefault(java.lang.String)
	 * @generated
	 */
	public void testSetDefault() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#unsetDefault() <em>unsetDefault()</em>}' method.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#unsetDefault()
	 * @generated
	 */
	public void testUnsetDefault() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#isSetDefault() <em>isSetDefault()</em>}' method.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#isSetDefault()
	 * @generated
	 */
	public void testIsSetDefault() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#isComposite() <em>Is Composite</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#isComposite()
	 * @generated
	 */
	public void testIsComposite() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setIsComposite(boolean) <em>Is Composite</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setIsComposite(boolean)
	 * @generated
	 */
	public void testSetIsComposite() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#getClass_() <em>Class</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#getClass_()
	 * @generated
	 */
	public void testGetClass_() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#getOpposite() <em>Opposite</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#getOpposite()
	 * @generated
	 */
	public void testGetOpposite() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setOpposite(org.eclipse.uml2.uml.Property) <em>Opposite</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setOpposite(org.eclipse.uml2.uml.Property)
	 * @generated
	 */
	public void testSetOpposite() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#isCompatibleWith(org.eclipse.uml2.uml.ParameterableElement) <em>Is Compatible With</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#isCompatibleWith(org.eclipse.uml2.uml.ParameterableElement)
	 * @generated
	 */
	public void testIsCompatibleWith__ParameterableElement() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.ParameterableElement#isTemplateParameter() <em>Is Template Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.ParameterableElement#isTemplateParameter()
	 * @generated
	 */
	public void testIsTemplateParameter() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.TemplateableElement#parameterableElements() <em>Parameterable Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.TemplateableElement#parameterableElements()
	 * @generated
	 */
	public void testParameterableElements() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.TemplateableElement#isTemplate() <em>Is Template</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.TemplateableElement#isTemplate()
	 * @generated NOT
	 */
	public void testIsTemplate() {
		assertFalse(getFixture().isTemplate());

		getFixture().createOwnedTemplateSignature();

		assertTrue(getFixture().isTemplate());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateMultiplicityOfComposite(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Multiplicity Of Composite</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateMultiplicityOfComposite(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateMultiplicityOfComposite__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateSubsettingContextConforms(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Subsetting Context Conforms</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateSubsettingContextConforms(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateSubsettingContextConforms__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateRedefinedPropertyInherited(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Redefined Property Inherited</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateRedefinedPropertyInherited(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateRedefinedPropertyInherited__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateSubsettingRules(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Subsetting Rules</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateSubsettingRules(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateSubsettingRules__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateNavigableReadonly(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Navigable Readonly</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateNavigableReadonly(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateNavigableReadonly__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateDerivedUnionIsDerived(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Derived Union Is Derived</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateDerivedUnionIsDerived(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateDerivedUnionIsDerived__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateDerivedUnionIsReadOnly(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Derived Union Is Read Only</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateDerivedUnionIsReadOnly(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateDerivedUnionIsReadOnly__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateSubsettedPropertyNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Subsetted Property Names</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateSubsettedPropertyNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateSubsettedPropertyNames__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateDeploymentTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Deployment Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateDeploymentTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateDeploymentTarget__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#validateBindingToAttribute(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Binding To Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#validateBindingToAttribute(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateBindingToAttribute__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setIsNavigable(boolean) <em>Set Is Navigable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setIsNavigable(boolean)
	 * @generated NOT
	 */
	public void testSetIsNavigable__boolean() {

		try {
			getFixture().setIsNavigable(true);
			fail();
		} catch (IllegalStateException ise) {
			// pass
		}

		Property property = UMLFactory.eINSTANCE.createProperty();
		property.getQualifiers().add(getFixture());

		try {
			getFixture().setIsNavigable(true);
			fail();
		} catch (IllegalStateException ise) {
			// pass
		}

		org.eclipse.uml2.uml.Class class_ = UMLFactory.eINSTANCE.createClass();
		class_.getOwnedAttributes().add(getFixture());

		try {
			getFixture().setIsNavigable(true);
		} catch (IllegalStateException ise) {
			fail();
		}

		try {
			getFixture().setIsNavigable(false);
			fail();
		} catch (IllegalStateException ise) {
			// pass
		}

		Association association = UMLFactory.eINSTANCE.createAssociation();
		association.getMemberEnds().add(getFixture());

		try {
			getFixture().setIsNavigable(false);
		} catch (IllegalStateException ise) {
			fail();
		}

		assertTrue(association.getOwnedEnds().contains(getFixture()));
		assertFalse(association.getNavigableOwnedEnds().contains(getFixture()));

		try {
			getFixture().setIsNavigable(true);
		} catch (IllegalStateException ise) {
			fail();
		}

		assertTrue(association.getNavigableOwnedEnds().contains(getFixture()));
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#getOtherEnd() <em>Get Other End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#getOtherEnd()
	 * @generated
	 */
	public void testGetOtherEnd() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setBooleanDefaultValue(boolean) <em>Set Boolean Default Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setBooleanDefaultValue(boolean)
	 * @generated NOT
	 */
	public void testSetBooleanDefaultValue__boolean() {
		assertNull(getFixture().getDefaultValue());

		getFixture().setBooleanDefaultValue(true);

		ValueSpecification defaultValue = getFixture().getDefaultValue();

		assertTrue(defaultValue instanceof LiteralBoolean);
		assertEquals(true, ((LiteralBoolean) defaultValue).isValue());

		getFixture().setBooleanDefaultValue(false);

		assertSame(defaultValue, getFixture().getDefaultValue());
		assertEquals(false, ((LiteralBoolean) defaultValue).isValue());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setIntegerDefaultValue(int) <em>Set Integer Default Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setIntegerDefaultValue(int)
	 * @generated NOT
	 */
	public void testSetIntegerDefaultValue__int() {

		assertNull(getFixture().getDefaultValue());

		getFixture().setIntegerDefaultValue(Integer.MIN_VALUE);

		ValueSpecification defaultValue = getFixture().getDefaultValue();

		assertTrue(defaultValue instanceof LiteralInteger);
		assertEquals(Integer.MIN_VALUE, ((LiteralInteger) defaultValue)
			.getValue());

		getFixture().setIntegerDefaultValue(Integer.MAX_VALUE);

		assertSame(defaultValue, getFixture().getDefaultValue());
		assertEquals(Integer.MAX_VALUE, ((LiteralInteger) defaultValue)
			.getValue());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setStringDefaultValue(java.lang.String) <em>Set String Default Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setStringDefaultValue(java.lang.String)
	 * @generated NOT
	 */
	public void testSetStringDefaultValue__String() {
		assertNull(getFixture().getDefaultValue());

		getFixture().setStringDefaultValue(getName());

		ValueSpecification defaultValue = getFixture().getDefaultValue();

		assertTrue(defaultValue instanceof LiteralString);
		assertEquals(getName(), ((LiteralString) defaultValue).getValue());

		getFixture().setStringDefaultValue(null);

		assertSame(defaultValue, getFixture().getDefaultValue());
		assertNull(((LiteralString) defaultValue).getValue());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setUnlimitedNaturalDefaultValue(int) <em>Set Unlimited Natural Default Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setUnlimitedNaturalDefaultValue(int)
	 * @generated NOT
	 */
	public void testSetUnlimitedNaturalDefaultValue__int() {
		assertNull(getFixture().getDefaultValue());

		getFixture().setUnlimitedNaturalDefaultValue(
			LiteralUnlimitedNatural.UNLIMITED);

		ValueSpecification defaultValue = getFixture().getDefaultValue();

		assertTrue(defaultValue instanceof LiteralUnlimitedNatural);
		assertEquals(LiteralUnlimitedNatural.UNLIMITED,
			((LiteralUnlimitedNatural) defaultValue).getValue());

		getFixture().setUnlimitedNaturalDefaultValue(0);

		assertSame(defaultValue, getFixture().getDefaultValue());
		assertEquals(0, ((LiteralUnlimitedNatural) defaultValue).getValue());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#setNullDefaultValue() <em>Set Null Default Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#setNullDefaultValue()
	 * @generated NOT
	 */
	public void testSetNullDefaultValue() {
		assertNull(getFixture().getDefaultValue());

		getFixture().setNullDefaultValue();

		ValueSpecification defaultValue = getFixture().getDefaultValue();

		assertTrue(defaultValue instanceof LiteralNull);
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#isAttribute(org.eclipse.uml2.uml.Property) <em>Is Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#isAttribute(org.eclipse.uml2.uml.Property)
	 * @generated
	 */
	public void testIsAttribute__Property() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#subsettingContext() <em>Subsetting Context</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#subsettingContext()
	 * @generated
	 */
	public void testSubsettingContext() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#isNavigable() <em>Is Navigable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#isNavigable()
	 * @generated NOT
	 */
	public void testIsNavigable() {
		assertFalse(getFixture().isNavigable());

		org.eclipse.uml2.uml.Class class_ = UMLFactory.eINSTANCE.createClass();
		class_.getOwnedAttributes().add(getFixture());

		assertTrue(getFixture().isNavigable());

		Association association = UMLFactory.eINSTANCE.createAssociation();
		association.getOwnedEnds().add(getFixture());

		assertFalse(getFixture().isNavigable());

		association.getNavigableOwnedEnds().add(getFixture());

		assertTrue(getFixture().isNavigable());
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.Property#isConsistentWith(org.eclipse.uml2.uml.RedefinableElement) <em>Is Consistent With</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.Property#isConsistentWith(org.eclipse.uml2.uml.RedefinableElement)
	 * @generated NOT
	 */
	public void testIsConsistentWith__RedefinableElement() {
		assertFalse(getFixture().isConsistentWith(null));

		Property redefinee = UMLFactory.eINSTANCE.createProperty();

		assertFalse(getFixture().isConsistentWith(redefinee));

		StructuredClassifier redefinitionContext = UMLFactory.eINSTANCE
			.createClass();
		redefinitionContext.getOwnedAttributes().add(getFixture());

		assertFalse(getFixture().isConsistentWith(redefinee));

		StructuredClassifier redefineeRedefinitionContext = UMLFactory.eINSTANCE
			.createClass();
		redefineeRedefinitionContext.getOwnedAttributes().add(redefinee);

		assertFalse(getFixture().isConsistentWith(redefinee));

		redefineeRedefinitionContext.createGeneralization(redefinitionContext);

		assertTrue(getFixture().isConsistentWith(redefinee));

		Classifier type = UMLFactory.eINSTANCE.createDataType();

		getFixture().setType(type);

		assertFalse(getFixture().isConsistentWith(redefinee));

		Classifier redefineeType = UMLFactory.eINSTANCE.createDataType();

		redefinee.setType(redefineeType);

		assertFalse(getFixture().isConsistentWith(redefinee));

		redefineeType.createGeneralization(type);

		assertTrue(getFixture().isConsistentWith(redefinee));

		LiteralInteger lowerValue = (LiteralInteger) getFixture()
			.createLowerValue(null, null, UMLPackage.Literals.LITERAL_INTEGER);
		LiteralInteger redefineeLowerValue = (LiteralInteger) redefinee
			.createLowerValue(null, null, UMLPackage.Literals.LITERAL_INTEGER);

		lowerValue.setValue(1);
		redefineeLowerValue.setValue(0);

		assertFalse(getFixture().isConsistentWith(redefinee));

		lowerValue.setValue(0);

		assertTrue(getFixture().isConsistentWith(redefinee));

		LiteralUnlimitedNatural upperValue = (LiteralUnlimitedNatural) getFixture()
			.createUpperValue(null, null,
				UMLPackage.Literals.LITERAL_UNLIMITED_NATURAL);
		LiteralUnlimitedNatural redefineeUpperValue = (LiteralUnlimitedNatural) redefinee
			.createUpperValue(null, null,
				UMLPackage.Literals.LITERAL_UNLIMITED_NATURAL);

		upperValue.setValue(1);
		redefineeUpperValue.setValue(Integer.MAX_VALUE);

		assertFalse(getFixture().isConsistentWith(redefinee));

		upperValue.setValue(LiteralUnlimitedNatural.UNLIMITED);

		assertTrue(getFixture().isConsistentWith(redefinee));

		getFixture().setIsDerived(true);

		assertFalse(getFixture().isConsistentWith(redefinee));

		redefinee.setIsDerived(true);

		assertTrue(getFixture().isConsistentWith(redefinee));

		getFixture().setAggregation(AggregationKind.COMPOSITE_LITERAL);

		assertFalse(getFixture().isConsistentWith(redefinee));

		redefinee.setAggregation(AggregationKind.COMPOSITE_LITERAL);

		assertTrue(getFixture().isConsistentWith(redefinee));
	}

} //PropertyTest
