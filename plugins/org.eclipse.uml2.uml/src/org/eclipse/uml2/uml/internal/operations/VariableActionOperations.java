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
 * $Id: VariableActionOperations.java,v 1.1 2005/11/14 22:25:54 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.VariableAction;

import org.eclipse.uml2.uml.util.UMLValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Variable Action</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.VariableAction#validateScopeOfVariable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Scope Of Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public final class VariableActionOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VariableActionOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The action must be in the scope of the variable.
	 * self.variable.isAccessibleBy(self)
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateScopeOfVariable(
			VariableAction variableAction, DiagnosticChain diagnostics,
			Map context) {
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
						UMLValidator.VARIABLE_ACTION__SCOPE_OF_VARIABLE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateScopeOfVariable", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(variableAction, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{variableAction}));
			}
			return false;
		}
		return true;
	}

} // VariableActionOperations