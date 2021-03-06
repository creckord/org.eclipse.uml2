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

import org.eclipse.uml2.uml.InformationFlow;

import org.eclipse.uml2.uml.util.UMLValidator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Information Flow</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#validateSourcesAndTargetsKind(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Sources And Targets Kind</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#validateMustConform(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Must Conform</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.InformationFlow#validateConveyClassifiers(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Convey Classifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InformationFlowOperations
		extends NamedElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InformationFlowOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sources and targets of the information flow can only be one of the following kind: Actor, Node, UseCase, Artifact, Class, Component, Port, Property, Interface, Package, ActivityNode, ActivityPartition and InstanceSpecification except when its classifier is a relationship (i.e. it represents a link).
	 * (self.informationSource->forAll(p | p->oclIsKindOf(Actor) or oclIsKindOf(Node) or
	 *   oclIsKindOf(UseCase) or oclIsKindOf(Artifact) or oclIsKindOf(Class) or
	 *   oclIsKindOf(Component) or oclIsKindOf(Port) or oclIsKindOf(Property) or
	 *   oclIsKindOf(Interface) or oclIsKindOf(Package) or oclIsKindOf(ActivityNode) or
	 *   oclIsKindOf(ActivityPartition) or oclIsKindOf(InstanceSpecification))) and
	 *     (self.informationTarget->forAll(p | p->oclIsKindOf(Actor) or oclIsKindOf(Node) or
	 *       oclIsKindOf(UseCase) or oclIsKindOf(Artifact) or oclIsKindOf(Class) or
	 *       oclIsKindOf(Component) or oclIsKindOf(Port) or oclIsKindOf(Property) or
	 *       oclIsKindOf(Interface) or oclIsKindOf(Package) or oclIsKindOf(ActivityNode) or
	 *       oclIsKindOf(ActivityPartition) or oclIsKindOf(InstanceSpecification)))
	 * @param informationFlow The receiving '<em><b>Information Flow</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateSourcesAndTargetsKind(
			InformationFlow informationFlow, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
						UMLValidator.INFORMATION_FLOW__SOURCES_AND_TARGETS_KIND,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateSourcesAndTargetsKind", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(informationFlow, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{informationFlow}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sources and targets of the information flow must conform with the sources and targets or conversely the targets and sources of the realization relationships.
	 * true
	 * @param informationFlow The receiving '<em><b>Information Flow</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateMustConform(InformationFlow informationFlow,
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
						UMLValidator.INFORMATION_FLOW__MUST_CONFORM,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateMustConform", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(informationFlow, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{informationFlow}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An information flow can only convey classifiers that are allowed to represent an information item.
	 * self.conveyed.represented->forAll(p | p->oclIsKindOf(Class) or oclIsKindOf(Interface)
	 *   or oclIsKindOf(InformationItem) or oclIsKindOf(Signal) or oclIsKindOf(Component))
	 * @param informationFlow The receiving '<em><b>Information Flow</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean validateConveyClassifiers(
			InformationFlow informationFlow, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
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
						UMLValidator.INFORMATION_FLOW__CONVEY_CLASSIFIERS,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"validateConveyClassifiers", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(informationFlow, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{informationFlow}));
			}
			return false;
		}
		return true;
	}

} // InformationFlowOperations