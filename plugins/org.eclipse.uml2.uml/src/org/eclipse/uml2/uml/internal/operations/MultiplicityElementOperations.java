/*
 * Copyright (c) 2005, 2011 IBM Corporation, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey (CEA) - 327039, 351774
 *
 */
package org.eclipse.uml2.uml.internal.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.ValueSpecification;

import org.eclipse.uml2.uml.util.UMLValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Multiplicity Element</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#validateLowerGe0(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Lower Ge0</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#validateUpperGeLower(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Upper Ge Lower</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#validateValueSpecificationConstant(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Value Specification Constant</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#validateValueSpecificationNoSideEffects(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Value Specification No Side Effects</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#setLower(int) <em>Set Lower</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#setUpper(int) <em>Set Upper</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#compatibleWith(org.eclipse.uml2.uml.MultiplicityElement) <em>Compatible With</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#includesCardinality(int) <em>Includes Cardinality</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#includesMultiplicity(org.eclipse.uml2.uml.MultiplicityElement) <em>Includes Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#is(int, int) <em>Is</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#isMultivalued() <em>Is Multivalued</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#getLower() <em>Get Lower</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#lowerBound() <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#getUpper() <em>Get Upper</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.MultiplicityElement#upperBound() <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicityElementOperations
		extends ElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicityElementOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The lower bound must be a non-negative integer literal.
	 * lowerBound()->notEmpty() implies lowerBound() >= 0
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean validateLowerGe0(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;

		int lowerBound = multiplicityElement.lowerBound();

		if (lowerBound < 0) {
			result = false;

			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(Diagnostic.WARNING,
						UMLValidator.DIAGNOSTIC_SOURCE,
						UMLValidator.MULTIPLICITY_ELEMENT__LOWER_GE0,
						UMLPlugin.INSTANCE.getString(
							"_UI_MultiplicityElement_LowerGE0_diagnostic", //$NON-NLS-1$
							getMessageSubstitutions(context,
								multiplicityElement)), new Object[]{
							multiplicityElement, new Integer(lowerBound)}));
			}
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The upper bound must be greater than or equal to the lower bound.
	 * (upperBound()->notEmpty() and lowerBound()->notEmpty()) implies upperBound() >= lowerBound()
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean validateUpperGeLower(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;

		int upperBound = multiplicityElement.upperBound();

		if (upperBound != LiteralUnlimitedNatural.UNLIMITED
			&& upperBound < multiplicityElement.lowerBound()) {

			result = false;

			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(Diagnostic.WARNING,
						UMLValidator.DIAGNOSTIC_SOURCE,
						UMLValidator.MULTIPLICITY_ELEMENT__UPPER_GE_LOWER,
						UMLPlugin.INSTANCE.getString(
							"_UI_MultiplicityElement_UpperGELower_diagnostic", //$NON-NLS-1$
							getMessageSubstitutions(context,
								multiplicityElement)), new Object[]{
							multiplicityElement, new Integer(upperBound)}));
			}
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a non-literal ValueSpecification is used for the lower or upper bound, then evaluating that specification must not have side effects.
	 * true
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateValueSpecificationNoSideEffects(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						UMLValidator.DIAGNOSTIC_SOURCE,
						UMLValidator.MULTIPLICITY_ELEMENT__VALUE_SPECIFICATION_NO_SIDE_EFFECTS,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateValueSpecificationNoSideEffects", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(multiplicityElement, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{multiplicityElement}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a non-literal ValueSpecification is used for the lower or upper bound, then that specification must be a constant expression.
	 * true
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateValueSpecificationConstant(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						UMLValidator.DIAGNOSTIC_SOURCE,
						UMLValidator.MULTIPLICITY_ELEMENT__VALUE_SPECIFICATION_CONSTANT,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateValueSpecificationConstant", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(multiplicityElement, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{multiplicityElement}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The derived lower attribute must equal the lowerBound.
	 * result = lowerBound()
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static int getLower(MultiplicityElement multiplicityElement) {
		return multiplicityElement.lowerBound();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The derived upper attribute must equal the upperBound.
	 * result = upperBound()
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static int getUpper(MultiplicityElement multiplicityElement) {
		return multiplicityElement.upperBound();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isMultivalued() checks whether this multiplicity has an upper bound greater than one.
	 * upperBound()->notEmpty()
	 * result = upperBound() > 1
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean isMultivalued(MultiplicityElement multiplicityElement) {
		int upperBound = multiplicityElement.upperBound();
		return upperBound == LiteralUnlimitedNatural.UNLIMITED
			|| upperBound > 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query includesCardinality() checks whether the specified cardinality is valid for this multiplicity.
	 * upperBound()->notEmpty() and lowerBound()->notEmpty()
	 * result = (lowerBound() <= C) and (upperBound() >= C)
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean includesCardinality(
			MultiplicityElement multiplicityElement, int C) {

		if (C == LiteralUnlimitedNatural.UNLIMITED) {
			return multiplicityElement.upperBound() == LiteralUnlimitedNatural.UNLIMITED;
		} else {

			if (multiplicityElement.lowerBound() <= C) {
				int upperBound = multiplicityElement.upperBound();
				return upperBound == LiteralUnlimitedNatural.UNLIMITED
					? true
					: upperBound >= C;
			} else {
				return false;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query includesMultiplicity() checks whether this multiplicity includes all the cardinalities allowed by the specified multiplicity.
	 * self.upperBound()->notEmpty() and self.lowerBound()->notEmpty() and M.upperBound()->notEmpty() and M.lowerBound()->notEmpty()
	 * result = (self.lowerBound() <= M.lowerBound()) and (self.upperBound() >= M.upperBound())
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean includesMultiplicity(
			MultiplicityElement multiplicityElement, MultiplicityElement M) {

		if (multiplicityElement.lowerBound() <= M.lowerBound()) {
			int upperBound = multiplicityElement.upperBound();

			if (upperBound == LiteralUnlimitedNatural.UNLIMITED) {
				return true;
			} else {
				int mUpperBound = M.upperBound();
				return mUpperBound == LiteralUnlimitedNatural.UNLIMITED
					? false
					: upperBound >= mUpperBound;
			}
		} else {
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query lowerBound() returns the lower bound of the multiplicity as an integer.
	 * result = if lowerValue->isEmpty() then 1 else lowerValue.integerValue() endif
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static int lowerBound(MultiplicityElement multiplicityElement) {
		ValueSpecification lowerValue = multiplicityElement.getLowerValue();

		if (lowerValue != null) {

			try {
				return lowerValue.integerValue();
			} catch (UnsupportedOperationException uoe) {
				// do nothing
			}
		}

		return 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query upperBound() returns the upper bound of the multiplicity for a bounded multiplicity as an unlimited natural.
	 * result = if upperValue->isEmpty() then 1 else upperValue.unlimitedValue() endif
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static int upperBound(MultiplicityElement multiplicityElement) {
		ValueSpecification upperValue = multiplicityElement.getUpperValue();

		if (upperValue != null) {

			try {
				return upperValue.unlimitedValue();
			} catch (UnsupportedOperationException uoe) {
				// do nothing
			}
		}

		return 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operation compatibleWith takes another multiplicity as input. It checks if one multiplicity is compatible with another.
	 * result = Integer.allInstances()->forAll(i : Integer | self.includesCardinality(i) implies other.includesCardinality(i))
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean compatibleWith(
			MultiplicityElement multiplicityElement, MultiplicityElement other) {
		return other != null && other.includesMultiplicity(multiplicityElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operation is determines if the upper and lower bound of the ranges are the ones given.
	 * result = (lowerbound = self.lowerbound and upperbound = self.upperbound)
	 * @param multiplicityElement The receiving '<em><b>Multiplicity Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean is(MultiplicityElement multiplicityElement,
			int lowerbound, int upperbound) {
		return multiplicityElement.lowerBound() == lowerbound
			&& multiplicityElement.upperBound() == upperbound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static void setLower(MultiplicityElement multiplicityElement,
			int newLower) {
		ValueSpecification lowerValue = multiplicityElement.getLowerValue();

		((LiteralInteger) (lowerValue instanceof LiteralInteger
			? lowerValue
			: multiplicityElement.createLowerValue(null, null,
				UMLPackage.Literals.LITERAL_INTEGER))).setValue(newLower);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static void setUpper(MultiplicityElement multiplicityElement,
			int newUpper) {
		ValueSpecification upperValue = multiplicityElement.getUpperValue();

		((LiteralUnlimitedNatural) (upperValue instanceof LiteralUnlimitedNatural
			? upperValue
			: multiplicityElement.createUpperValue(null, null,
				UMLPackage.Literals.LITERAL_UNLIMITED_NATURAL)))
			.setValue(newUpper);
	}

} // MultiplicityElementOperations