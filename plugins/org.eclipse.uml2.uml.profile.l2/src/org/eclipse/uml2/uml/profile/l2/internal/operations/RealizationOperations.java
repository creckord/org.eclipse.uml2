/*
 * Copyright (c) 2011 CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA - initial API and implementation
 *   Kenn Hussey (CEA) - 351774
 *
 */
package org.eclipse.uml2.uml.profile.l2.internal.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.profile.l2.ImplementationClass;
import org.eclipse.uml2.uml.profile.l2.L2Plugin;
import org.eclipse.uml2.uml.profile.l2.Realization;

import org.eclipse.uml2.uml.profile.l2.util.L2Validator;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Realization</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.profile.l2.Realization#validateCannotBeImplementationClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Cannot Be Implementation Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated not
 */
public class RealizationOperations
		extends UMLUtil {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealizationOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.base_Classifier.extension_ImplementationClass->isEmpty()
	 * @param realization The receiving '<em><b>Realization</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean validateCannotBeImplementationClass(
			Realization realization, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		boolean result = true;

		Classifier base_Classifier = realization.getBase_Classifier();

		if (base_Classifier != null
			&& getStereotypeApplication(base_Classifier,
				ImplementationClass.class) != null) {

			result = false;

			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.WARNING,
						L2Validator.DIAGNOSTIC_SOURCE,
						L2Validator.REALIZATION__CANNOT_BE_IMPLEMENTATION_CLASS,
						L2Plugin.INSTANCE
							.getString(
								"_UI_Realization_CannotBeImplementationClass_diagnostic", //$NON-NLS-1$
								getMessageSubstitutions(context,
									base_Classifier)),
						new Object[]{base_Classifier}));
			}
		}

		return result;
	}

} // RealizationOperations