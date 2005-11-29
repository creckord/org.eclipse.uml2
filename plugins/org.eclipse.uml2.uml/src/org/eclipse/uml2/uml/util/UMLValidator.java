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
 * $Id: UMLValidator.java,v 1.3 2005/11/23 20:01:13 khussey Exp $
 */
package org.eclipse.uml2.uml.util;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.AddVariableValueAction;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.BroadcastSignalAction;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.CentralBufferNode;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.ClearAssociationAction;
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.ClearVariableAction;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectableElementTemplateParameter;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.ControlNode;
import org.eclipse.uml2.uml.CreateLinkAction;
import org.eclipse.uml2.uml.CreateLinkObjectAction;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.CreationEvent;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DeployedArtifact;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.DeploymentTarget;
import org.eclipse.uml2.uml.DestroyLinkAction;
import org.eclipse.uml2.uml.DestroyObjectAction;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.DurationObservationAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.ExecutionEvent;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LinkAction;
import org.eclipse.uml2.uml.LinkEndCreationData;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.LinkEndDestructionData;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageEvent;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OperationTemplateParameter;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.PartDecomposition;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ProtocolConformance;
import org.eclipse.uml2.uml.ProtocolStateMachine;
import org.eclipse.uml2.uml.ProtocolTransition;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.QualifierValue;
import org.eclipse.uml2.uml.RaiseExceptionAction;
import org.eclipse.uml2.uml.ReadExtentAction;
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;
import org.eclipse.uml2.uml.ReadLinkAction;
import org.eclipse.uml2.uml.ReadLinkObjectEndAction;
import org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.ReadVariableAction;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.ReclassifyObjectAction;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction;
import org.eclipse.uml2.uml.RemoveVariableValueAction;
import org.eclipse.uml2.uml.ReplyAction;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.SendSignalEvent;
import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StartClassifierBehaviorAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.StructuralFeatureAction;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.TestIdentityAction;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.TimeObservationAction;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UnmarshallAction;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.ValueSpecificationAction;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VariableAction;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.WriteLinkAction;
import org.eclipse.uml2.uml.WriteStructuralFeatureAction;
import org.eclipse.uml2.uml.WriteVariableAction;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.uml.UMLPackage
 * @generated
 */
public class UMLValidator
		extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UMLValidator INSTANCE = new UMLValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.uml2.uml"; //$NON-NLS-1$

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Own Self' of 'Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT__NOT_OWN_SELF = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has Owner' of 'Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT__HAS_OWNER = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has No Qualified Name' of 'Named Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMED_ELEMENT__HAS_NO_QUALIFIED_NAME = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has Qualified Name' of 'Named Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMED_ELEMENT__HAS_QUALIFIED_NAME = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Visibility Needs Ownership' of 'Named Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMED_ELEMENT__VISIBILITY_NEEDS_OWNERSHIP = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Be Compatible' of 'Template Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_PARAMETER__MUST_BE_COMPATIBLE = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Own Elements' of 'Template Signature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_SIGNATURE__OWN_ELEMENTS = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parameter Substitution Formal' of 'Template Binding'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_BINDING__PARAMETER_SUBSTITUTION_FORMAL = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Parameter Substitution' of 'Template Binding'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_BINDING__ONE_PARAMETER_SUBSTITUTION = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Be Compatible' of 'Template Parameter Substitution'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_PARAMETER_SUBSTITUTION__MUST_BE_COMPATIBLE = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Members Distinguishable' of 'Namespace'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NAMESPACE__MEMBERS_DISTINGUISHABLE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Visibility Public Or Private' of 'Element Import'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT_IMPORT__VISIBILITY_PUBLIC_OR_PRIVATE = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Visibility Or Private' of 'Element Import'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT_IMPORT__VISIBILITY_OR_PRIVATE = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Imported Element Is Public' of 'Element Import'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ELEMENT_IMPORT__IMPORTED_ELEMENT_IS_PUBLIC = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Public Or Private' of 'Package Import'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PACKAGE_IMPORT__PUBLIC_OR_PRIVATE = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Elements Public Or Private' of 'Package'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PACKAGE__ELEMENTS_PUBLIC_OR_PRIVATE = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Metaclass Reference Not Specialized' of 'Profile'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROFILE__METACLASS_REFERENCE_NOT_SPECIALIZED = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate References Same Metamodel' of 'Profile'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROFILE__REFERENCES_SAME_METAMODEL = 18;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Not Clash' of 'Stereotype'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE__NAME_NOT_CLASH = 19;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Generalize' of 'Stereotype'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STEREOTYPE__GENERALIZE = 20;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Passive Class' of 'Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASS__PASSIVE_CLASS = 21;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Class Behavior' of 'Behaviored Classifier'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIORED_CLASSIFIER__CLASS_BEHAVIOR = 22;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Cycles In Generalization' of 'Classifier'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER__NO_CYCLES_IN_GENERALIZATION = 23;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Specialize Type' of 'Classifier'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER__SPECIALIZE_TYPE = 25;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Generalization Hierarchies' of 'Classifier'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER__GENERALIZATION_HIERARCHIES = 24;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Maps To Generalization Set' of 'Classifier'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER__MAPS_TO_GENERALIZATION_SET = 26;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Redefinition Context Valid' of 'Redefinable Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REDEFINABLE_ELEMENT__REDEFINITION_CONTEXT_VALID = 27;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Redefinition Consistent' of 'Redefinable Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REDEFINABLE_ELEMENT__REDEFINITION_CONSISTENT = 28;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Generalization Same Classifier' of 'Generalization'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GENERALIZATION__GENERALIZATION_SAME_CLASSIFIER = 29;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Generalization Same Classifier' of 'Generalization Set'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GENERALIZATION_SET__GENERALIZATION_SAME_CLASSIFIER = 30;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Maps To Generalization Set' of 'Generalization Set'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GENERALIZATION_SET__MAPS_TO_GENERALIZATION_SET = 31;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Have Name' of 'Use Case'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int USE_CASE__MUST_HAVE_NAME = 32;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Binary Associations' of 'Use Case'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int USE_CASE__BINARY_ASSOCIATIONS = 33;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Association To Use Case' of 'Use Case'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int USE_CASE__NO_ASSOCIATION_TO_USE_CASE = 34;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Cannot Include Self' of 'Use Case'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int USE_CASE__CANNOT_INCLUDE_SELF = 35;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Extension Points' of 'Extend'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTEND__EXTENSION_POINTS = 36;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Apply To Self' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__NOT_APPLY_TO_SELF = 37;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Value Specification Boolean' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__VALUE_SPECIFICATION_BOOLEAN = 38;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Boolean Value' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__BOOLEAN_VALUE = 39;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Side Effects' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__NO_SIDE_EFFECTS = 40;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Applied To Self' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__NOT_APPLIED_TO_SELF = 41;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Have Name' of 'Extension Point'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTENSION_POINT__MUST_HAVE_NAME = 42;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Language Body Size' of 'Opaque Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPAQUE_EXPRESSION__LANGUAGE_BODY_SIZE = 43;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Body Default Language' of 'Opaque Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPAQUE_EXPRESSION__ONE_BODY_DEFAULT_LANGUAGE = 44;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Return Result Parameters' of 'Opaque Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPAQUE_EXPRESSION__ONLY_RETURN_RESULT_PARAMETERS = 45;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Return Result Parameter' of 'Opaque Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPAQUE_EXPRESSION__ONE_RETURN_RESULT_PARAMETER = 46;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Connector End' of 'Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER__CONNECTOR_END = 47;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Stream And Exception' of 'Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER__STREAM_AND_EXCEPTION = 48;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Exception' of 'Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER__NOT_EXCEPTION = 49;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Reentrant Behaviors' of 'Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER__REENTRANT_BEHAVIORS = 50;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate In And Out' of 'Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER__IN_AND_OUT = 51;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Upper Gt0' of 'Multiplicity Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLICITY_ELEMENT__UPPER_GT0 = 52;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Lower Ge0' of 'Multiplicity Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLICITY_ELEMENT__LOWER_GE0 = 53;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Upper Ge Lower' of 'Multiplicity Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLICITY_ELEMENT__UPPER_GE_LOWER = 54;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Value Specification No Side Effects' of 'Multiplicity Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLICITY_ELEMENT__VALUE_SPECIFICATION_NO_SIDE_EFFECTS = 55;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Value Specification Constant' of 'Multiplicity Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLICITY_ELEMENT__VALUE_SPECIFICATION_CONSTANT = 56;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Connector End'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR_END__MULTIPLICITY = 57;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Part With Port Empty' of 'Connector End'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR_END__PART_WITH_PORT_EMPTY = 58;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Role And Part With Port' of 'Connector End'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR_END__ROLE_AND_PART_WITH_PORT = 59;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Self Part With Port' of 'Connector End'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR_END__SELF_PART_WITH_PORT = 60;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Composite' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__MULTIPLICITY_OF_COMPOSITE = 61;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Subsetting Context Conforms' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__SUBSETTING_CONTEXT_CONFORMS = 62;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Navigable Property Redefinition' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__NAVIGABLE_PROPERTY_REDEFINITION = 63;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Subsetting Rules' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__SUBSETTING_RULES = 64;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Navigable Readonly' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__NAVIGABLE_READONLY = 65;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Derived Union Is Derived' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__DERIVED_UNION_IS_DERIVED = 66;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Derived Union Is Read Only' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__DERIVED_UNION_IS_READ_ONLY = 67;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Deployment Target' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__DEPLOYMENT_TARGET = 68;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Binding To Attribute' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__BINDING_TO_ATTRIBUTE = 69;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Deployed Elements' of 'Deployment Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DEPLOYMENT_SPECIFICATION__DEPLOYED_ELEMENTS = 70;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Deployment Target' of 'Deployment Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DEPLOYMENT_SPECIFICATION__DEPLOYMENT_TARGET = 71;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate At Most One Return' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__AT_MOST_ONE_RETURN = 72;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Only Body For Query' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__ONLY_BODY_FOR_QUERY = 73;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parameters Match' of 'Behavior'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR__PARAMETERS_MATCH = 74;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Feature Of Context Classifier' of 'Behavior'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR__FEATURE_OF_CONTEXT_CLASSIFIER = 75;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Realize' of 'Behavior'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR__MUST_REALIZE = 76;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Most One Behaviour' of 'Behavior'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BEHAVIOR__MOST_ONE_BEHAVIOUR = 77;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Parameterized Entity' of 'Parameter Set'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER_SET__SAME_PARAMETERIZED_ENTITY = 78;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input' of 'Parameter Set'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER_SET__INPUT = 79;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Two Parameter Sets' of 'Parameter Set'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARAMETER_SET__TWO_PARAMETER_SETS = 80;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Visibility' of 'Interface'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERFACE__VISIBILITY = 81;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Query' of 'Reception'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RECEPTION__NOT_QUERY = 82;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Protocol Transitions' of 'Protocol State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOCOL_STATE_MACHINE__PROTOCOL_TRANSITIONS = 83;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Entry Exit Do' of 'Protocol State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOCOL_STATE_MACHINE__ENTRY_EXIT_DO = 84;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Deep Or Shallow History' of 'Protocol State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOCOL_STATE_MACHINE__DEEP_OR_SHALLOW_HISTORY = 85;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Ports Connected' of 'Protocol State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOCOL_STATE_MACHINE__PORTS_CONNECTED = 86;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Classifier Context' of 'Protocol State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOCOL_STATE_MACHINE__CLASSIFIER_CONTEXT = 87;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Classifier Context' of 'State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE_MACHINE__CLASSIFIER_CONTEXT = 88;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Context Classifier' of 'State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE_MACHINE__CONTEXT_CLASSIFIER = 89;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Connection Points' of 'State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE_MACHINE__CONNECTION_POINTS = 90;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Method' of 'State Machine'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE_MACHINE__METHOD = 91;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Initial Vertex' of 'Region'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REGION__INITIAL_VERTEX = 92;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Deep History Vertex' of 'Region'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REGION__DEEP_HISTORY_VERTEX = 93;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Shallow History Vertex' of 'Region'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REGION__SHALLOW_HISTORY_VERTEX = 94;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Owned' of 'Region'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REGION__OWNED = 95;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Fork Segment Guards' of 'Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSITION__FORK_SEGMENT_GUARDS = 96;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Join Segment Guards' of 'Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSITION__JOIN_SEGMENT_GUARDS = 97;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Fork Segment State' of 'Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSITION__FORK_SEGMENT_STATE = 98;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Join Segment State' of 'Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSITION__JOIN_SEGMENT_STATE = 99;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Outgoing Pseudostates' of 'Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSITION__OUTGOING_PSEUDOSTATES = 100;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Initial Transition' of 'Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSITION__INITIAL_TRANSITION = 101;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Signatures Compatible' of 'Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSITION__SIGNATURES_COMPATIBLE = 102;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Required Interfaces' of 'Port'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PORT__REQUIRED_INTERFACES = 103;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Port Aggregation' of 'Port'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PORT__PORT_AGGREGATION = 104;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Port Destroyed' of 'Port'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PORT__PORT_DESTROYED = 105;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Default Value' of 'Port'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PORT__DEFAULT_VALUE = 106;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Regions' of 'State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE__REGIONS = 107;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Submachine States' of 'State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE__SUBMACHINE_STATES = 108;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Destinations Or Sources Of Transitions' of 'State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE__DESTINATIONS_OR_SOURCES_OF_TRANSITIONS = 109;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Submachine Or Regions' of 'State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE__SUBMACHINE_OR_REGIONS = 110;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Composite States' of 'State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE__COMPOSITE_STATES = 111;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Entry Or Exit' of 'State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STATE__ENTRY_OR_EXIT = 112;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Entry Pseudostates' of 'Connection Point Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTION_POINT_REFERENCE__ENTRY_PSEUDOSTATES = 113;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Exit Pseudostates' of 'Connection Point Reference'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTION_POINT_REFERENCE__EXIT_PSEUDOSTATES = 114;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Initial Vertex' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__INITIAL_VERTEX = 115;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate History Vertices' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__HISTORY_VERTICES = 116;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Join Vertex' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__JOIN_VERTEX = 117;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Transitions Incoming' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__TRANSITIONS_INCOMING = 118;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Fork Vertex' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__FORK_VERTEX = 119;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Transitions Outgoing' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__TRANSITIONS_OUTGOING = 120;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Junction Vertex' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__JUNCTION_VERTEX = 121;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Choice Vertex' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__CHOICE_VERTEX = 122;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Outgoing From Initial' of 'Pseudostate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PSEUDOSTATE__OUTGOING_FROM_INITIAL = 123;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Specialized End Number' of 'Association'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSOCIATION__SPECIALIZED_END_NUMBER = 124;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Specialized End Types' of 'Association'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSOCIATION__SPECIALIZED_END_TYPES = 125;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Binary Associations' of 'Association'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSOCIATION__BINARY_ASSOCIATIONS = 126;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Association Ends' of 'Association'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSOCIATION__ASSOCIATION_ENDS = 127;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Client Elements' of 'Collaboration Use'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLABORATION_USE__CLIENT_ELEMENTS = 128;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Every Role' of 'Collaboration Use'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLABORATION_USE__EVERY_ROLE = 129;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Connectors' of 'Collaboration Use'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLABORATION_USE__CONNECTORS = 130;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicities' of 'Structured Classifier'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRUCTURED_CLASSIFIER__MULTIPLICITIES = 131;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Types' of 'Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR__TYPES = 132;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible' of 'Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR__COMPATIBLE = 133;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Roles' of 'Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR__ROLES = 134;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Between Interfaces Ports' of 'Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR__BETWEEN_INTERFACES_PORTS = 135;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Between Interface Port Implements' of 'Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR__BETWEEN_INTERFACE_PORT_IMPLEMENTS = 136;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Between Interface Port Signature' of 'Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR__BETWEEN_INTERFACE_PORT_SIGNATURE = 137;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Union Signature Compatible' of 'Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR__UNION_SIGNATURE_COMPATIBLE = 138;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Assembly Connector' of 'Connector'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONNECTOR__ASSEMBLY_CONNECTOR = 139;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Inherited Parameters' of 'Redefinable Template Signature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REDEFINABLE_TEMPLATE_SIGNATURE__INHERITED_PARAMETERS = 140;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has Constraining Classifier' of 'Classifier Template Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLASSIFIER_TEMPLATE_PARAMETER__HAS_CONSTRAINING_CLASSIFIER = 141;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Non Owned End' of 'Extension'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTENSION__NON_OWNED_END = 142;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Binary' of 'Extension'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTENSION__IS_BINARY = 143;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Extension End'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTENSION_END__MULTIPLICITY = 144;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Aggregation' of 'Extension End'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXTENSION_END__AGGREGATION = 145;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Operands' of 'String Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRING_EXPRESSION__OPERANDS = 146;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Subexpressions' of 'String Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRING_EXPRESSION__SUBEXPRESSIONS = 147;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Defining Feature' of 'Instance Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_SPECIFICATION__DEFINING_FEATURE = 148;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Structural Feature' of 'Instance Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_SPECIFICATION__STRUCTURAL_FEATURE = 149;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Deployment Target' of 'Instance Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_SPECIFICATION__DEPLOYMENT_TARGET = 150;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Deployment Artifact' of 'Instance Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INSTANCE_SPECIFICATION__DEPLOYMENT_ARTIFACT = 151;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Output Parameter' of 'Function Behavior'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_BEHAVIOR__ONE_OUTPUT_PARAMETER = 152;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Types Of Parameters' of 'Function Behavior'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_BEHAVIOR__TYPES_OF_PARAMETERS = 153;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Associations' of 'Actor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTOR__ASSOCIATIONS = 154;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Have Name' of 'Actor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTOR__MUST_HAVE_NAME = 155;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sending Receiving Message Event' of 'Message'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE__SENDING_RECEIVING_MESSAGE_EVENT = 156;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Signature Refer To' of 'Message'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE__SIGNATURE_REFER_TO = 157;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Signature Is Operation' of 'Message'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE__SIGNATURE_IS_OPERATION = 158;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Signature Is Signal' of 'Message'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE__SIGNATURE_IS_SIGNAL = 159;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Arguments' of 'Message'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE__ARGUMENTS = 160;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Cannot Cross Boundaries' of 'Message'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE__CANNOT_CROSS_BOUNDARIES = 161;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Occurrence Specifications' of 'Message'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE__OCCURRENCE_SPECIFICATIONS = 162;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Interaction Uses Share Lifeline' of 'Lifeline'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LIFELINE__INTERACTION_USES_SHARE_LIFELINE = 163;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Selector Specified' of 'Lifeline'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LIFELINE__SELECTOR_SPECIFIED = 164;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Classifier' of 'Lifeline'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LIFELINE__SAME_CLASSIFIER = 165;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parts Of Internal Structures' of 'Part Decomposition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PART_DECOMPOSITION__PARTS_OF_INTERNAL_STRUCTURES = 166;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Assume' of 'Part Decomposition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PART_DECOMPOSITION__ASSUME = 167;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Commutativity Of Decomposition' of 'Part Decomposition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PART_DECOMPOSITION__COMMUTATIVITY_OF_DECOMPOSITION = 168;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Gates Match' of 'Interaction Use'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_USE__GATES_MATCH = 169;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate All Lifelines' of 'Interaction Use'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_USE__ALL_LIFELINES = 170;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Arguments Correspond To Parameters' of 'Interaction Use'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_USE__ARGUMENTS_CORRESPOND_TO_PARAMETERS = 171;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Arguments Are Constants' of 'Interaction Use'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_USE__ARGUMENTS_ARE_CONSTANTS = 172;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Messages Actual Gate' of 'Gate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GATE__MESSAGES_ACTUAL_GATE = 173;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Messages Combined Fragment' of 'Gate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GATE__MESSAGES_COMBINED_FRAGMENT = 174;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Owned' of 'Activity Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_NODE__OWNED = 175;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Owned Structured Node' of 'Activity Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_NODE__OWNED_STRUCTURED_NODE = 176;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Source And Target' of 'Activity Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_EDGE__SOURCE_AND_TARGET = 177;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Owned' of 'Activity Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_EDGE__OWNED = 178;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Structured Node' of 'Activity Edge'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_EDGE__STRUCTURED_NODE = 179;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Supergroups' of 'Activity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY__NO_SUPERGROUPS = 180;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Activity Parameter Node' of 'Activity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY__ACTIVITY_PARAMETER_NODE = 181;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Autonomous' of 'Activity'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY__AUTONOMOUS = 182;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Dimension Not Contained' of 'Activity Partition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARTITION__DIMENSION_NOT_CONTAINED = 183;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Node Or Edge' of 'Activity Partition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARTITION__NODE_OR_EDGE = 184;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Represents Part' of 'Activity Partition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARTITION__REPRESENTS_PART = 185;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Represents Classifier' of 'Activity Partition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARTITION__REPRESENTS_CLASSIFIER = 186;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Represents Part And Is Contained' of 'Activity Partition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARTITION__REPRESENTS_PART_AND_IS_CONTAINED = 187;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Nodes And Edges' of 'Activity Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_GROUP__NODES_AND_EDGES = 188;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Contained' of 'Activity Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_GROUP__NOT_CONTAINED = 189;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Group Owned' of 'Activity Group'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_GROUP__GROUP_OWNED = 190;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Edges' of 'Structured Activity Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRUCTURED_ACTIVITY_NODE__EDGES = 191;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Owned' of 'Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE__OWNED = 192;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Interrupting Edges' of 'Interruptible Activity Region'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERRUPTIBLE_ACTIVITY_REGION__INTERRUPTING_EDGES = 193;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Exception Body' of 'Exception Handler'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXCEPTION_HANDLER__EXCEPTION_BODY = 194;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Result Pins' of 'Exception Handler'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXCEPTION_HANDLER__RESULT_PINS = 195;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Input' of 'Exception Handler'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXCEPTION_HANDLER__ONE_INPUT = 196;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Edge Source Target' of 'Exception Handler'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXCEPTION_HANDLER__EDGE_SOURCE_TARGET = 197;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Object Flow Edges' of 'Object Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_NODE__OBJECT_FLOW_EDGES = 198;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Unique' of 'Object Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_NODE__NOT_UNIQUE = 199;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Selection Behavior' of 'Object Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_NODE__SELECTION_BEHAVIOR = 200;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input Output Parameter' of 'Object Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_NODE__INPUT_OUTPUT_PARAMETER = 201;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Control Pins' of 'Pin'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PIN__CONTROL_PINS = 202;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Guard Directly Prior' of 'Interaction Operand'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_OPERAND__GUARD_DIRECTLY_PRIOR = 203;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Guard Contain References' of 'Interaction Operand'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_OPERAND__GUARD_CONTAIN_REFERENCES = 204;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Dynamic Variables' of 'Interaction Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_CONSTRAINT__DYNAMIC_VARIABLES = 205;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Global Data' of 'Interaction Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_CONSTRAINT__GLOBAL_DATA = 206;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Minint Maxint' of 'Interaction Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_CONSTRAINT__MININT_MAXINT = 207;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Minint Non Negative' of 'Interaction Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_CONSTRAINT__MININT_NON_NEGATIVE = 208;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Maxint Positive' of 'Interaction Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_CONSTRAINT__MAXINT_POSITIVE = 209;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Maxint Greater Equal Minint' of 'Interaction Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INTERACTION_CONSTRAINT__MAXINT_GREATER_EQUAL_MININT = 210;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Lifeline' of 'Execution Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXECUTION_SPECIFICATION__SAME_LIFELINE = 211;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Action Referenced' of 'Action Execution Specification'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTION_EXECUTION_SPECIFICATION__ACTION_REFERENCED = 212;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Occurrence Above' of 'Creation Event'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATION_EVENT__NO_OCCURRENCE_ABOVE = 213;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Occurrence Specifications Below' of 'Destruction Event'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DESTRUCTION_EVENT__NO_OCCURRENCE_SPECIFICATIONS_BELOW = 214;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Opt Loop Break Neg' of 'Combined Fragment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMBINED_FRAGMENT__OPT_LOOP_BREAK_NEG = 215;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Minint And Maxint' of 'Combined Fragment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMBINED_FRAGMENT__MININT_AND_MAXINT = 216;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Break' of 'Combined Fragment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMBINED_FRAGMENT__BREAK = 217;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Consider And Ignore' of 'Combined Fragment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMBINED_FRAGMENT__CONSIDER_AND_IGNORE = 218;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Name' of 'Continuation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTINUATION__SAME_NAME = 219;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Global' of 'Continuation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTINUATION__GLOBAL = 220;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate First Or Last Interaction Fragment' of 'Continuation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTINUATION__FIRST_OR_LAST_INTERACTION_FRAGMENT = 221;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Consider Or Ignore' of 'Consider Ignore Fragment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSIDER_IGNORE_FRAGMENT__CONSIDER_OR_IGNORE = 222;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type' of 'Consider Ignore Fragment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSIDER_IGNORE_FRAGMENT__TYPE = 223;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Classifier Not Abstract' of 'Create Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATE_OBJECT_ACTION__CLASSIFIER_NOT_ABSTRACT = 224;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Classifier Not Association Class' of 'Create Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATE_OBJECT_ACTION__CLASSIFIER_NOT_ASSOCIATION_CLASS = 225;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Type' of 'Create Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATE_OBJECT_ACTION__SAME_TYPE = 226;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Create Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATE_OBJECT_ACTION__MULTIPLICITY = 227;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Destroy Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DESTROY_OBJECT_ACTION__MULTIPLICITY = 228;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Type' of 'Destroy Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DESTROY_OBJECT_ACTION__NO_TYPE = 229;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Type' of 'Test Identity Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEST_IDENTITY_ACTION__NO_TYPE = 230;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Test Identity Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEST_IDENTITY_ACTION__MULTIPLICITY = 231;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Result Is Boolean' of 'Test Identity Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEST_IDENTITY_ACTION__RESULT_IS_BOOLEAN = 232;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Contained' of 'Read Self Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_SELF_ACTION__CONTAINED = 233;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Static' of 'Read Self Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_SELF_ACTION__NOT_STATIC = 234;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type' of 'Read Self Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_SELF_ACTION__TYPE = 235;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Read Self Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_SELF_ACTION__MULTIPLICITY = 236;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Static' of 'Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRUCTURAL_FEATURE_ACTION__NOT_STATIC = 237;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Type' of 'Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRUCTURAL_FEATURE_ACTION__SAME_TYPE = 238;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRUCTURAL_FEATURE_ACTION__MULTIPLICITY = 239;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Visibility' of 'Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRUCTURAL_FEATURE_ACTION__VISIBILITY = 240;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Featuring Classifier' of 'Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int STRUCTURAL_FEATURE_ACTION__ONE_FEATURING_CLASSIFIER = 241;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type And Ordering' of 'Read Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_STRUCTURAL_FEATURE_ACTION__TYPE_AND_ORDERING = 242;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Read Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_STRUCTURAL_FEATURE_ACTION__MULTIPLICITY = 243;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input Pin' of 'Write Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WRITE_STRUCTURAL_FEATURE_ACTION__INPUT_PIN = 244;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Write Structural Feature Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WRITE_STRUCTURAL_FEATURE_ACTION__MULTIPLICITY = 245;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Non Unique Removal' of 'Remove Structural Feature Value Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REMOVE_STRUCTURAL_FEATURE_VALUE_ACTION__NON_UNIQUE_REMOVAL = 246;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unlimited Natural And Multiplicity' of 'Add Structural Feature Value Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ADD_STRUCTURAL_FEATURE_VALUE_ACTION__UNLIMITED_NATURAL_AND_MULTIPLICITY = 247;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Association' of 'Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_ACTION__SAME_ASSOCIATION = 248;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Static' of 'Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_ACTION__NOT_STATIC = 249;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Pins' of 'Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_ACTION__SAME_PINS = 250;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Property Is Association End' of 'Link End Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_DATA__PROPERTY_IS_ASSOCIATION_END = 251;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Type' of 'Link End Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_DATA__SAME_TYPE = 252;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Link End Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_DATA__MULTIPLICITY = 253;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Qualifiers' of 'Link End Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_DATA__QUALIFIERS = 254;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate End Object Input Pin' of 'Link End Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_DATA__END_OBJECT_INPUT_PIN = 255;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Qualifier Attribute' of 'Qualifier Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIER_VALUE__QUALIFIER_ATTRIBUTE = 256;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Of Qualifier' of 'Qualifier Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIER_VALUE__TYPE_OF_QUALIFIER = 257;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Qualifier' of 'Qualifier Value'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int QUALIFIER_VALUE__MULTIPLICITY_OF_QUALIFIER = 258;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Open End' of 'Read Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_ACTION__ONE_OPEN_END = 259;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type And Ordering' of 'Read Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_ACTION__TYPE_AND_ORDERING = 260;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Multiplicity' of 'Read Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_ACTION__COMPATIBLE_MULTIPLICITY = 261;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Navigable Open End' of 'Read Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_ACTION__NAVIGABLE_OPEN_END = 262;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Visibility' of 'Read Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_ACTION__VISIBILITY = 263;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Create Link Action' of 'Link End Creation Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_CREATION_DATA__CREATE_LINK_ACTION = 264;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Single Input Pin' of 'Link End Creation Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_CREATION_DATA__SINGLE_INPUT_PIN = 265;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Association Not Abstract' of 'Create Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATE_LINK_ACTION__ASSOCIATION_NOT_ABSTRACT = 266;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Allow Access' of 'Write Link Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WRITE_LINK_ACTION__ALLOW_ACCESS = 267;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Destroy Link Action' of 'Link End Destruction Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_DESTRUCTION_DATA__DESTROY_LINK_ACTION = 268;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unlimited Natural And Multiplicity' of 'Link End Destruction Data'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LINK_END_DESTRUCTION_DATA__UNLIMITED_NATURAL_AND_MULTIPLICITY = 269;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Type' of 'Clear Association Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLEAR_ASSOCIATION_ACTION__SAME_TYPE = 270;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Clear Association Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLEAR_ASSOCIATION_ACTION__MULTIPLICITY = 271;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Number And Order' of 'Broadcast Signal Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BROADCAST_SIGNAL_ACTION__NUMBER_AND_ORDER = 272;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Ordering Multiplicity' of 'Broadcast Signal Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BROADCAST_SIGNAL_ACTION__TYPE_ORDERING_MULTIPLICITY = 273;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate On Port Receiver' of 'Invocation Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INVOCATION_ACTION__ON_PORT_RECEIVER = 274;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type' of 'Value Specification Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VALUE_SPECIFICATION_ACTION__COMPATIBLE_TYPE = 275;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Value Specification Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VALUE_SPECIFICATION_ACTION__MULTIPLICITY = 276;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input Value Time Expression' of 'Time Observation Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TIME_OBSERVATION_ACTION__INPUT_VALUE_TIME_EXPRESSION = 277;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type' of 'Value Pin'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VALUE_PIN__COMPATIBLE_TYPE = 278;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input Value Duration' of 'Duration Observation Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DURATION_OBSERVATION_ACTION__INPUT_VALUE_DURATION = 279;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Synchronous Call' of 'Call Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_ACTION__SYNCHRONOUS_CALL = 280;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Number And Order' of 'Call Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_ACTION__NUMBER_AND_ORDER = 281;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Ordering Multiplicity' of 'Call Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_ACTION__TYPE_ORDERING_MULTIPLICITY = 282;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Number Order' of 'Send Signal Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEND_SIGNAL_ACTION__NUMBER_ORDER = 283;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Ordering Multiplicity' of 'Send Signal Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SEND_SIGNAL_ACTION__TYPE_ORDERING_MULTIPLICITY = 284;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Argument Pin Equal Parameter' of 'Call Operation Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_OPERATION_ACTION__ARGUMENT_PIN_EQUAL_PARAMETER = 285;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Result Pin Equal Parameter' of 'Call Operation Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_OPERATION_ACTION__RESULT_PIN_EQUAL_PARAMETER = 286;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Target Pin' of 'Call Operation Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_OPERATION_ACTION__TYPE_TARGET_PIN = 287;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Ordering Multiplicity' of 'Call Operation Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_OPERATION_ACTION__TYPE_ORDERING_MULTIPLICITY = 288;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Argument Pin Equal Parameter' of 'Call Behavior Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_BEHAVIOR_ACTION__ARGUMENT_PIN_EQUAL_PARAMETER = 289;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Result Pin Equal Parameter' of 'Call Behavior Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_BEHAVIOR_ACTION__RESULT_PIN_EQUAL_PARAMETER = 290;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Ordering Multiplicity' of 'Call Behavior Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CALL_BEHAVIOR_ACTION__TYPE_ORDERING_MULTIPLICITY = 291;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sources And Targets' of 'Information Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFORMATION_ITEM__SOURCES_AND_TARGETS = 292;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has No' of 'Information Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFORMATION_ITEM__HAS_NO = 293;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Instantiable' of 'Information Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFORMATION_ITEM__NOT_INSTANTIABLE = 294;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Sources And Targets Kind' of 'Information Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFORMATION_FLOW__SOURCES_AND_TARGETS_KIND = 295;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Conform' of 'Information Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFORMATION_FLOW__MUST_CONFORM = 296;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Convey Classifiers' of 'Information Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INFORMATION_FLOW__CONVEY_CLASSIFIERS = 297;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Scope Of Variable' of 'Variable Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE_ACTION__SCOPE_OF_VARIABLE = 298;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type And Ordering' of 'Read Variable Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_VARIABLE_ACTION__TYPE_AND_ORDERING = 299;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Multiplicity' of 'Read Variable Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_VARIABLE_ACTION__COMPATIBLE_MULTIPLICITY = 300;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Type' of 'Write Variable Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WRITE_VARIABLE_ACTION__SAME_TYPE = 301;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Write Variable Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int WRITE_VARIABLE_ACTION__MULTIPLICITY = 302;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Single Input Pin' of 'Add Variable Value Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ADD_VARIABLE_VALUE_ACTION__SINGLE_INPUT_PIN = 303;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unlimited Natural' of 'Remove Variable Value Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REMOVE_VARIABLE_VALUE_ACTION__UNLIMITED_NATURAL = 304;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Output Pin' of 'Action Input Pin'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTION_INPUT_PIN__ONE_OUTPUT_PIN = 305;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input Pin' of 'Action Input Pin'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTION_INPUT_PIN__INPUT_PIN = 306;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Control Or Data Flow' of 'Action Input Pin'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTION_INPUT_PIN__NO_CONTROL_OR_DATA_FLOW = 307;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Classifier' of 'Read Extent Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_EXTENT_ACTION__TYPE_IS_CLASSIFIER = 308;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Result' of 'Read Extent Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_EXTENT_ACTION__MULTIPLICITY_OF_RESULT = 309;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Classifier Not Abstract' of 'Reclassify Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RECLASSIFY_OBJECT_ACTION__CLASSIFIER_NOT_ABSTRACT = 310;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Reclassify Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RECLASSIFY_OBJECT_ACTION__MULTIPLICITY = 311;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input Pin' of 'Reclassify Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RECLASSIFY_OBJECT_ACTION__INPUT_PIN = 312;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Input' of 'Read Is Classified Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_IS_CLASSIFIED_OBJECT_ACTION__MULTIPLICITY_OF_INPUT = 313;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Type' of 'Read Is Classified Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_IS_CLASSIFIED_OBJECT_ACTION__NO_TYPE = 314;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Output' of 'Read Is Classified Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_IS_CLASSIFIED_OBJECT_ACTION__MULTIPLICITY_OF_OUTPUT = 315;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Boolean Result' of 'Read Is Classified Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_IS_CLASSIFIED_OBJECT_ACTION__BOOLEAN_RESULT = 316;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Start Classifier Behavior Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int START_CLASSIFIER_BEHAVIOR_ACTION__MULTIPLICITY = 317;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Has Classifier' of 'Start Classifier Behavior Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int START_CLASSIFIER_BEHAVIOR_ACTION__TYPE_HAS_CLASSIFIER = 318;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Property' of 'Read Link Object End Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_ACTION__PROPERTY = 319;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Association Of Association' of 'Read Link Object End Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_ACTION__ASSOCIATION_OF_ASSOCIATION = 320;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Ends Of Association' of 'Read Link Object End Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_ACTION__ENDS_OF_ASSOCIATION = 321;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Of Object' of 'Read Link Object End Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_ACTION__TYPE_OF_OBJECT = 322;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Object' of 'Read Link Object End Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_ACTION__MULTIPLICITY_OF_OBJECT = 323;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Of Result' of 'Read Link Object End Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_ACTION__TYPE_OF_RESULT = 324;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Result' of 'Read Link Object End Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_ACTION__MULTIPLICITY_OF_RESULT = 325;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Qualifier Attribute' of 'Read Link Object End Qualifier Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_QUALIFIER_ACTION__QUALIFIER_ATTRIBUTE = 326;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Association Of Association' of 'Read Link Object End Qualifier Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_QUALIFIER_ACTION__ASSOCIATION_OF_ASSOCIATION = 327;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Ends Of Association' of 'Read Link Object End Qualifier Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_QUALIFIER_ACTION__ENDS_OF_ASSOCIATION = 328;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Of Object' of 'Read Link Object End Qualifier Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_QUALIFIER_ACTION__TYPE_OF_OBJECT = 329;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Qualifier' of 'Read Link Object End Qualifier Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_QUALIFIER_ACTION__MULTIPLICITY_OF_QUALIFIER = 330;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Object' of 'Read Link Object End Qualifier Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_QUALIFIER_ACTION__MULTIPLICITY_OF_OBJECT = 331;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Type' of 'Read Link Object End Qualifier Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_QUALIFIER_ACTION__SAME_TYPE = 332;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Result' of 'Read Link Object End Qualifier Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int READ_LINK_OBJECT_END_QUALIFIER_ACTION__MULTIPLICITY_OF_RESULT = 333;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Association Class' of 'Create Link Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATE_LINK_OBJECT_ACTION__ASSOCIATION_CLASS = 334;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Of Result' of 'Create Link Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATE_LINK_OBJECT_ACTION__TYPE_OF_RESULT = 335;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity' of 'Create Link Object Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CREATE_LINK_OBJECT_ACTION__MULTIPLICITY = 336;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Input Pins' of 'Accept Event Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_EVENT_ACTION__NO_INPUT_PINS = 337;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Output Pins' of 'Accept Event Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_EVENT_ACTION__NO_OUTPUT_PINS = 338;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Trigger Events' of 'Accept Event Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_EVENT_ACTION__TRIGGER_EVENTS = 339;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unmarshall Signal Events' of 'Accept Event Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_EVENT_ACTION__UNMARSHALL_SIGNAL_EVENTS = 340;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Result Pins' of 'Accept Call Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_CALL_ACTION__RESULT_PINS = 341;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Trigger Call Event' of 'Accept Call Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_CALL_ACTION__TRIGGER_CALL_EVENT = 342;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unmarshall' of 'Accept Call Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACCEPT_CALL_ACTION__UNMARSHALL = 343;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Pins Match Parameter' of 'Reply Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REPLY_ACTION__PINS_MATCH_PARAMETER = 344;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Event On Reply To Call Trigger' of 'Reply Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REPLY_ACTION__EVENT_ON_REPLY_TO_CALL_TRIGGER = 345;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Type' of 'Unmarshall Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNMARSHALL_ACTION__SAME_TYPE = 346;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Object' of 'Unmarshall Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNMARSHALL_ACTION__MULTIPLICITY_OF_OBJECT = 347;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Number Of Result' of 'Unmarshall Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNMARSHALL_ACTION__NUMBER_OF_RESULT = 348;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type And Ordering' of 'Unmarshall Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNMARSHALL_ACTION__TYPE_AND_ORDERING = 349;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Multiplicity Of Result' of 'Unmarshall Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNMARSHALL_ACTION__MULTIPLICITY_OF_RESULT = 350;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Structural Feature' of 'Unmarshall Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNMARSHALL_ACTION__STRUCTURAL_FEATURE = 351;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unmarshall Type Is Classifier' of 'Unmarshall Action'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int UNMARSHALL_ACTION__UNMARSHALL_TYPE_IS_CLASSIFIER = 352;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Object Nodes' of 'Control Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONTROL_FLOW__OBJECT_NODES = 353;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Incoming Edges' of 'Initial Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INITIAL_NODE__NO_INCOMING_EDGES = 354;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Control Edges' of 'Initial Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int INITIAL_NODE__CONTROL_EDGES = 355;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has Parameters' of 'Activity Parameter Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARAMETER_NODE__HAS_PARAMETERS = 356;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Type' of 'Activity Parameter Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARAMETER_NODE__SAME_TYPE = 357;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Edges' of 'Activity Parameter Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARAMETER_NODE__NO_EDGES = 358;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Incoming Edges' of 'Activity Parameter Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARAMETER_NODE__NO_INCOMING_EDGES = 359;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Outgoing Edges' of 'Activity Parameter Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ACTIVITY_PARAMETER_NODE__NO_OUTGOING_EDGES = 360;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Incoming Edge' of 'Fork Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FORK_NODE__ONE_INCOMING_EDGE = 361;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Edges' of 'Fork Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FORK_NODE__EDGES = 362;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Outgoing Edges' of 'Final Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FINAL_NODE__NO_OUTGOING_EDGES = 363;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Outgoing Edge' of 'Merge Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MERGE_NODE__ONE_OUTGOING_EDGE = 364;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Edges' of 'Merge Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MERGE_NODE__EDGES = 365;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Incoming Edge' of 'Decision Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DECISION_NODE__ONE_INCOMING_EDGE = 366;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input Parameter' of 'Decision Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DECISION_NODE__INPUT_PARAMETER = 367;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Edges' of 'Decision Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DECISION_NODE__EDGES = 368;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Outgoing Edge' of 'Join Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int JOIN_NODE__ONE_OUTGOING_EDGE = 369;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Incoming Object Flow' of 'Join Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int JOIN_NODE__INCOMING_OBJECT_FLOW = 370;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Actions' of 'Object Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_FLOW__NO_ACTIONS = 371;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Types' of 'Object Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_FLOW__COMPATIBLE_TYPES = 372;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Same Upper Bounds' of 'Object Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_FLOW__SAME_UPPER_BOUNDS = 373;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target' of 'Object Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_FLOW__TARGET = 374;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Transformation Behaviour' of 'Object Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_FLOW__TRANSFORMATION_BEHAVIOUR = 375;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Selection Behaviour' of 'Object Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_FLOW__SELECTION_BEHAVIOUR = 376;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input And Output Parameter' of 'Object Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_FLOW__INPUT_AND_OUTPUT_PARAMETER = 377;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is Multicast Or Is Multireceive' of 'Object Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_FLOW__IS_MULTICAST_OR_IS_MULTIRECEIVE = 378;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Result No Incoming' of 'Conditional Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONDITIONAL_NODE__RESULT_NO_INCOMING = 379;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Decider Output' of 'Clause'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLAUSE__DECIDER_OUTPUT = 380;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Body Output Pins' of 'Clause'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CLAUSE__BODY_OUTPUT_PINS = 381;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Input Edges' of 'Loop Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_NODE__INPUT_EDGES = 382;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Body Output Pins' of 'Loop Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_NODE__BODY_OUTPUT_PINS = 383;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Result No Incoming' of 'Loop Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP_NODE__RESULT_NO_INCOMING = 384;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Expansion Nodes' of 'Expansion Region'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EXPANSION_REGION__EXPANSION_NODES = 385;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Internal Structure' of 'Node'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NODE__INTERNAL_STRUCTURE = 386;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Association Ends' of 'Communication Path'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMMUNICATION_PATH__ASSOCIATION_ENDS = 387;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Outgoing Transitions' of 'Final State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FINAL_STATE__NO_OUTGOING_TRANSITIONS = 388;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Regions' of 'Final State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FINAL_STATE__NO_REGIONS = 389;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Cannot Reference Submachine' of 'Final State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FINAL_STATE__CANNOT_REFERENCE_SUBMACHINE = 390;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Entry Behavior' of 'Final State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FINAL_STATE__NO_ENTRY_BEHAVIOR = 391;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Exitbehavior' of 'Final State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FINAL_STATE__NO_EXITBEHAVIOR = 392;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No State Behavior' of 'Final State'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FINAL_STATE__NO_STATE_BEHAVIOR = 393;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Starting Time' of 'Time Event'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TIME_EVENT__STARTING_TIME = 394;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Belongs Psm' of 'Protocol Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOCOL_TRANSITION__BELONGS_PSM = 395;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Associated Actions' of 'Protocol Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOCOL_TRANSITION__ASSOCIATED_ACTIONS = 396;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Refers To Operation' of 'Protocol Transition'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROTOCOL_TRANSITION__REFERS_TO_OPERATION = 397;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Cannot Be Defined' of 'Association Class'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ASSOCIATION_CLASS__CANNOT_BE_DEFINED = 398;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 398;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPackage getEPackage() {
		return UMLPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value,
			DiagnosticChain diagnostics, Map context) {
		switch (classifierID) {
			case UMLPackage.COMMENT :
				return validateComment((Comment) value, diagnostics, context);
			case UMLPackage.ELEMENT :
				return validateElement((Element) value, diagnostics, context);
			case UMLPackage.DIRECTED_RELATIONSHIP :
				return validateDirectedRelationship(
					(DirectedRelationship) value, diagnostics, context);
			case UMLPackage.RELATIONSHIP :
				return validateRelationship((Relationship) value, diagnostics,
					context);
			case UMLPackage.LITERAL_SPECIFICATION :
				return validateLiteralSpecification(
					(LiteralSpecification) value, diagnostics, context);
			case UMLPackage.VALUE_SPECIFICATION :
				return validateValueSpecification((ValueSpecification) value,
					diagnostics, context);
			case UMLPackage.TYPED_ELEMENT :
				return validateTypedElement((TypedElement) value, diagnostics,
					context);
			case UMLPackage.NAMED_ELEMENT :
				return validateNamedElement((NamedElement) value, diagnostics,
					context);
			case UMLPackage.DEPENDENCY :
				return validateDependency((Dependency) value, diagnostics,
					context);
			case UMLPackage.PACKAGEABLE_ELEMENT :
				return validatePackageableElement((PackageableElement) value,
					diagnostics, context);
			case UMLPackage.PARAMETERABLE_ELEMENT :
				return validateParameterableElement(
					(ParameterableElement) value, diagnostics, context);
			case UMLPackage.TEMPLATE_PARAMETER :
				return validateTemplateParameter((TemplateParameter) value,
					diagnostics, context);
			case UMLPackage.TEMPLATE_SIGNATURE :
				return validateTemplateSignature((TemplateSignature) value,
					diagnostics, context);
			case UMLPackage.TEMPLATEABLE_ELEMENT :
				return validateTemplateableElement((TemplateableElement) value,
					diagnostics, context);
			case UMLPackage.TEMPLATE_BINDING :
				return validateTemplateBinding((TemplateBinding) value,
					diagnostics, context);
			case UMLPackage.TEMPLATE_PARAMETER_SUBSTITUTION :
				return validateTemplateParameterSubstitution(
					(TemplateParameterSubstitution) value, diagnostics, context);
			case UMLPackage.NAMESPACE :
				return validateNamespace((Namespace) value, diagnostics,
					context);
			case UMLPackage.ELEMENT_IMPORT :
				return validateElementImport((ElementImport) value,
					diagnostics, context);
			case UMLPackage.PACKAGE_IMPORT :
				return validatePackageImport((PackageImport) value,
					diagnostics, context);
			case UMLPackage.PACKAGE :
				return validatePackage((org.eclipse.uml2.uml.Package) value,
					diagnostics, context);
			case UMLPackage.PACKAGE_MERGE :
				return validatePackageMerge((PackageMerge) value, diagnostics,
					context);
			case UMLPackage.TYPE :
				return validateType((Type) value, diagnostics, context);
			case UMLPackage.PROFILE_APPLICATION :
				return validateProfileApplication((ProfileApplication) value,
					diagnostics, context);
			case UMLPackage.PROFILE :
				return validateProfile((Profile) value, diagnostics, context);
			case UMLPackage.STEREOTYPE :
				return validateStereotype((Stereotype) value, diagnostics,
					context);
			case UMLPackage.CLASS :
				return validateClass((org.eclipse.uml2.uml.Class) value,
					diagnostics, context);
			case UMLPackage.BEHAVIORED_CLASSIFIER :
				return validateBehavioredClassifier(
					(BehavioredClassifier) value, diagnostics, context);
			case UMLPackage.CLASSIFIER :
				return validateClassifier((Classifier) value, diagnostics,
					context);
			case UMLPackage.REDEFINABLE_ELEMENT :
				return validateRedefinableElement((RedefinableElement) value,
					diagnostics, context);
			case UMLPackage.GENERALIZATION :
				return validateGeneralization((Generalization) value,
					diagnostics, context);
			case UMLPackage.GENERALIZATION_SET :
				return validateGeneralizationSet((GeneralizationSet) value,
					diagnostics, context);
			case UMLPackage.FEATURE :
				return validateFeature((Feature) value, diagnostics, context);
			case UMLPackage.USE_CASE :
				return validateUseCase((UseCase) value, diagnostics, context);
			case UMLPackage.INCLUDE :
				return validateInclude((Include) value, diagnostics, context);
			case UMLPackage.EXTEND :
				return validateExtend((Extend) value, diagnostics, context);
			case UMLPackage.CONSTRAINT :
				return validateConstraint((Constraint) value, diagnostics,
					context);
			case UMLPackage.EXTENSION_POINT :
				return validateExtensionPoint((ExtensionPoint) value,
					diagnostics, context);
			case UMLPackage.SUBSTITUTION :
				return validateSubstitution((Substitution) value, diagnostics,
					context);
			case UMLPackage.REALIZATION :
				return validateRealization((Realization) value, diagnostics,
					context);
			case UMLPackage.ABSTRACTION :
				return validateAbstraction((Abstraction) value, diagnostics,
					context);
			case UMLPackage.OPAQUE_EXPRESSION :
				return validateOpaqueExpression((OpaqueExpression) value,
					diagnostics, context);
			case UMLPackage.PARAMETER :
				return validateParameter((Parameter) value, diagnostics,
					context);
			case UMLPackage.MULTIPLICITY_ELEMENT :
				return validateMultiplicityElement((MultiplicityElement) value,
					diagnostics, context);
			case UMLPackage.CONNECTABLE_ELEMENT :
				return validateConnectableElement((ConnectableElement) value,
					diagnostics, context);
			case UMLPackage.CONNECTOR_END :
				return validateConnectorEnd((ConnectorEnd) value, diagnostics,
					context);
			case UMLPackage.PROPERTY :
				return validateProperty((Property) value, diagnostics, context);
			case UMLPackage.DEPLOYMENT_TARGET :
				return validateDeploymentTarget((DeploymentTarget) value,
					diagnostics, context);
			case UMLPackage.DEPLOYMENT :
				return validateDeployment((Deployment) value, diagnostics,
					context);
			case UMLPackage.DEPLOYED_ARTIFACT :
				return validateDeployedArtifact((DeployedArtifact) value,
					diagnostics, context);
			case UMLPackage.DEPLOYMENT_SPECIFICATION :
				return validateDeploymentSpecification(
					(DeploymentSpecification) value, diagnostics, context);
			case UMLPackage.ARTIFACT :
				return validateArtifact((Artifact) value, diagnostics, context);
			case UMLPackage.MANIFESTATION :
				return validateManifestation((Manifestation) value,
					diagnostics, context);
			case UMLPackage.OPERATION :
				return validateOperation((Operation) value, diagnostics,
					context);
			case UMLPackage.BEHAVIORAL_FEATURE :
				return validateBehavioralFeature((BehavioralFeature) value,
					diagnostics, context);
			case UMLPackage.BEHAVIOR :
				return validateBehavior((Behavior) value, diagnostics, context);
			case UMLPackage.PARAMETER_SET :
				return validateParameterSet((ParameterSet) value, diagnostics,
					context);
			case UMLPackage.DATA_TYPE :
				return validateDataType((DataType) value, diagnostics, context);
			case UMLPackage.INTERFACE :
				return validateInterface((Interface) value, diagnostics,
					context);
			case UMLPackage.RECEPTION :
				return validateReception((Reception) value, diagnostics,
					context);
			case UMLPackage.SIGNAL :
				return validateSignal((Signal) value, diagnostics, context);
			case UMLPackage.PROTOCOL_STATE_MACHINE :
				return validateProtocolStateMachine(
					(ProtocolStateMachine) value, diagnostics, context);
			case UMLPackage.STATE_MACHINE :
				return validateStateMachine((StateMachine) value, diagnostics,
					context);
			case UMLPackage.REGION :
				return validateRegion((Region) value, diagnostics, context);
			case UMLPackage.VERTEX :
				return validateVertex((Vertex) value, diagnostics, context);
			case UMLPackage.TRANSITION :
				return validateTransition((Transition) value, diagnostics,
					context);
			case UMLPackage.TRIGGER :
				return validateTrigger((Trigger) value, diagnostics, context);
			case UMLPackage.EVENT :
				return validateEvent((Event) value, diagnostics, context);
			case UMLPackage.PORT :
				return validatePort((Port) value, diagnostics, context);
			case UMLPackage.STATE :
				return validateState((State) value, diagnostics, context);
			case UMLPackage.CONNECTION_POINT_REFERENCE :
				return validateConnectionPointReference(
					(ConnectionPointReference) value, diagnostics, context);
			case UMLPackage.PSEUDOSTATE :
				return validatePseudostate((Pseudostate) value, diagnostics,
					context);
			case UMLPackage.PROTOCOL_CONFORMANCE :
				return validateProtocolConformance((ProtocolConformance) value,
					diagnostics, context);
			case UMLPackage.OPERATION_TEMPLATE_PARAMETER :
				return validateOperationTemplateParameter(
					(OperationTemplateParameter) value, diagnostics, context);
			case UMLPackage.STRUCTURAL_FEATURE :
				return validateStructuralFeature((StructuralFeature) value,
					diagnostics, context);
			case UMLPackage.ASSOCIATION :
				return validateAssociation((Association) value, diagnostics,
					context);
			case UMLPackage.CONNECTABLE_ELEMENT_TEMPLATE_PARAMETER :
				return validateConnectableElementTemplateParameter(
					(ConnectableElementTemplateParameter) value, diagnostics,
					context);
			case UMLPackage.COLLABORATION_USE :
				return validateCollaborationUse((CollaborationUse) value,
					diagnostics, context);
			case UMLPackage.COLLABORATION :
				return validateCollaboration((Collaboration) value,
					diagnostics, context);
			case UMLPackage.STRUCTURED_CLASSIFIER :
				return validateStructuredClassifier(
					(StructuredClassifier) value, diagnostics, context);
			case UMLPackage.CONNECTOR :
				return validateConnector((Connector) value, diagnostics,
					context);
			case UMLPackage.REDEFINABLE_TEMPLATE_SIGNATURE :
				return validateRedefinableTemplateSignature(
					(RedefinableTemplateSignature) value, diagnostics, context);
			case UMLPackage.CLASSIFIER_TEMPLATE_PARAMETER :
				return validateClassifierTemplateParameter(
					(ClassifierTemplateParameter) value, diagnostics, context);
			case UMLPackage.INTERFACE_REALIZATION :
				return validateInterfaceRealization(
					(InterfaceRealization) value, diagnostics, context);
			case UMLPackage.ENCAPSULATED_CLASSIFIER :
				return validateEncapsulatedClassifier(
					(EncapsulatedClassifier) value, diagnostics, context);
			case UMLPackage.EXTENSION :
				return validateExtension((Extension) value, diagnostics,
					context);
			case UMLPackage.EXTENSION_END :
				return validateExtensionEnd((ExtensionEnd) value, diagnostics,
					context);
			case UMLPackage.IMAGE :
				return validateImage((Image) value, diagnostics, context);
			case UMLPackage.STRING_EXPRESSION :
				return validateStringExpression((StringExpression) value,
					diagnostics, context);
			case UMLPackage.EXPRESSION :
				return validateExpression((Expression) value, diagnostics,
					context);
			case UMLPackage.LITERAL_INTEGER :
				return validateLiteralInteger((LiteralInteger) value,
					diagnostics, context);
			case UMLPackage.LITERAL_STRING :
				return validateLiteralString((LiteralString) value,
					diagnostics, context);
			case UMLPackage.LITERAL_BOOLEAN :
				return validateLiteralBoolean((LiteralBoolean) value,
					diagnostics, context);
			case UMLPackage.LITERAL_NULL :
				return validateLiteralNull((LiteralNull) value, diagnostics,
					context);
			case UMLPackage.SLOT :
				return validateSlot((Slot) value, diagnostics, context);
			case UMLPackage.INSTANCE_SPECIFICATION :
				return validateInstanceSpecification(
					(InstanceSpecification) value, diagnostics, context);
			case UMLPackage.ENUMERATION :
				return validateEnumeration((Enumeration) value, diagnostics,
					context);
			case UMLPackage.ENUMERATION_LITERAL :
				return validateEnumerationLiteral((EnumerationLiteral) value,
					diagnostics, context);
			case UMLPackage.PRIMITIVE_TYPE :
				return validatePrimitiveType((PrimitiveType) value,
					diagnostics, context);
			case UMLPackage.INSTANCE_VALUE :
				return validateInstanceValue((InstanceValue) value,
					diagnostics, context);
			case UMLPackage.LITERAL_UNLIMITED_NATURAL :
				return validateLiteralUnlimitedNatural(
					(LiteralUnlimitedNatural) value, diagnostics, context);
			case UMLPackage.OPAQUE_BEHAVIOR :
				return validateOpaqueBehavior((OpaqueBehavior) value,
					diagnostics, context);
			case UMLPackage.FUNCTION_BEHAVIOR :
				return validateFunctionBehavior((FunctionBehavior) value,
					diagnostics, context);
			case UMLPackage.ACTOR :
				return validateActor((Actor) value, diagnostics, context);
			case UMLPackage.USAGE :
				return validateUsage((Usage) value, diagnostics, context);
			case UMLPackage.MESSAGE :
				return validateMessage((Message) value, diagnostics, context);
			case UMLPackage.MESSAGE_END :
				return validateMessageEnd((MessageEnd) value, diagnostics,
					context);
			case UMLPackage.INTERACTION :
				return validateInteraction((Interaction) value, diagnostics,
					context);
			case UMLPackage.INTERACTION_FRAGMENT :
				return validateInteractionFragment((InteractionFragment) value,
					diagnostics, context);
			case UMLPackage.LIFELINE :
				return validateLifeline((Lifeline) value, diagnostics, context);
			case UMLPackage.PART_DECOMPOSITION :
				return validatePartDecomposition((PartDecomposition) value,
					diagnostics, context);
			case UMLPackage.INTERACTION_USE :
				return validateInteractionUse((InteractionUse) value,
					diagnostics, context);
			case UMLPackage.GATE :
				return validateGate((Gate) value, diagnostics, context);
			case UMLPackage.ACTION :
				return validateAction((Action) value, diagnostics, context);
			case UMLPackage.EXECUTABLE_NODE :
				return validateExecutableNode((ExecutableNode) value,
					diagnostics, context);
			case UMLPackage.ACTIVITY_NODE :
				return validateActivityNode((ActivityNode) value, diagnostics,
					context);
			case UMLPackage.ACTIVITY_EDGE :
				return validateActivityEdge((ActivityEdge) value, diagnostics,
					context);
			case UMLPackage.ACTIVITY :
				return validateActivity((Activity) value, diagnostics, context);
			case UMLPackage.ACTIVITY_PARTITION :
				return validateActivityPartition((ActivityPartition) value,
					diagnostics, context);
			case UMLPackage.ACTIVITY_GROUP :
				return validateActivityGroup((ActivityGroup) value,
					diagnostics, context);
			case UMLPackage.STRUCTURED_ACTIVITY_NODE :
				return validateStructuredActivityNode(
					(StructuredActivityNode) value, diagnostics, context);
			case UMLPackage.VARIABLE :
				return validateVariable((Variable) value, diagnostics, context);
			case UMLPackage.INTERRUPTIBLE_ACTIVITY_REGION :
				return validateInterruptibleActivityRegion(
					(InterruptibleActivityRegion) value, diagnostics, context);
			case UMLPackage.EXCEPTION_HANDLER :
				return validateExceptionHandler((ExceptionHandler) value,
					diagnostics, context);
			case UMLPackage.OBJECT_NODE :
				return validateObjectNode((ObjectNode) value, diagnostics,
					context);
			case UMLPackage.OUTPUT_PIN :
				return validateOutputPin((OutputPin) value, diagnostics,
					context);
			case UMLPackage.PIN :
				return validatePin((Pin) value, diagnostics, context);
			case UMLPackage.INPUT_PIN :
				return validateInputPin((InputPin) value, diagnostics, context);
			case UMLPackage.GENERAL_ORDERING :
				return validateGeneralOrdering((GeneralOrdering) value,
					diagnostics, context);
			case UMLPackage.OCCURRENCE_SPECIFICATION :
				return validateOccurrenceSpecification(
					(OccurrenceSpecification) value, diagnostics, context);
			case UMLPackage.INTERACTION_OPERAND :
				return validateInteractionOperand((InteractionOperand) value,
					diagnostics, context);
			case UMLPackage.INTERACTION_CONSTRAINT :
				return validateInteractionConstraint(
					(InteractionConstraint) value, diagnostics, context);
			case UMLPackage.EXECUTION_SPECIFICATION :
				return validateExecutionSpecification(
					(ExecutionSpecification) value, diagnostics, context);
			case UMLPackage.EXECUTION_OCCURRENCE_SPECIFICATION :
				return validateExecutionOccurrenceSpecification(
					(ExecutionOccurrenceSpecification) value, diagnostics,
					context);
			case UMLPackage.EXECUTION_EVENT :
				return validateExecutionEvent((ExecutionEvent) value,
					diagnostics, context);
			case UMLPackage.STATE_INVARIANT :
				return validateStateInvariant((StateInvariant) value,
					diagnostics, context);
			case UMLPackage.ACTION_EXECUTION_SPECIFICATION :
				return validateActionExecutionSpecification(
					(ActionExecutionSpecification) value, diagnostics, context);
			case UMLPackage.BEHAVIOR_EXECUTION_SPECIFICATION :
				return validateBehaviorExecutionSpecification(
					(BehaviorExecutionSpecification) value, diagnostics,
					context);
			case UMLPackage.CREATION_EVENT :
				return validateCreationEvent((CreationEvent) value,
					diagnostics, context);
			case UMLPackage.DESTRUCTION_EVENT :
				return validateDestructionEvent((DestructionEvent) value,
					diagnostics, context);
			case UMLPackage.SEND_OPERATION_EVENT :
				return validateSendOperationEvent((SendOperationEvent) value,
					diagnostics, context);
			case UMLPackage.MESSAGE_EVENT :
				return validateMessageEvent((MessageEvent) value, diagnostics,
					context);
			case UMLPackage.SEND_SIGNAL_EVENT :
				return validateSendSignalEvent((SendSignalEvent) value,
					diagnostics, context);
			case UMLPackage.MESSAGE_OCCURRENCE_SPECIFICATION :
				return validateMessageOccurrenceSpecification(
					(MessageOccurrenceSpecification) value, diagnostics,
					context);
			case UMLPackage.COMBINED_FRAGMENT :
				return validateCombinedFragment((CombinedFragment) value,
					diagnostics, context);
			case UMLPackage.CONTINUATION :
				return validateContinuation((Continuation) value, diagnostics,
					context);
			case UMLPackage.CONSIDER_IGNORE_FRAGMENT :
				return validateConsiderIgnoreFragment(
					(ConsiderIgnoreFragment) value, diagnostics, context);
			case UMLPackage.CALL_EVENT :
				return validateCallEvent((CallEvent) value, diagnostics,
					context);
			case UMLPackage.CHANGE_EVENT :
				return validateChangeEvent((ChangeEvent) value, diagnostics,
					context);
			case UMLPackage.SIGNAL_EVENT :
				return validateSignalEvent((SignalEvent) value, diagnostics,
					context);
			case UMLPackage.ANY_RECEIVE_EVENT :
				return validateAnyReceiveEvent((AnyReceiveEvent) value,
					diagnostics, context);
			case UMLPackage.CREATE_OBJECT_ACTION :
				return validateCreateObjectAction((CreateObjectAction) value,
					diagnostics, context);
			case UMLPackage.DESTROY_OBJECT_ACTION :
				return validateDestroyObjectAction((DestroyObjectAction) value,
					diagnostics, context);
			case UMLPackage.TEST_IDENTITY_ACTION :
				return validateTestIdentityAction((TestIdentityAction) value,
					diagnostics, context);
			case UMLPackage.READ_SELF_ACTION :
				return validateReadSelfAction((ReadSelfAction) value,
					diagnostics, context);
			case UMLPackage.STRUCTURAL_FEATURE_ACTION :
				return validateStructuralFeatureAction(
					(StructuralFeatureAction) value, diagnostics, context);
			case UMLPackage.READ_STRUCTURAL_FEATURE_ACTION :
				return validateReadStructuralFeatureAction(
					(ReadStructuralFeatureAction) value, diagnostics, context);
			case UMLPackage.WRITE_STRUCTURAL_FEATURE_ACTION :
				return validateWriteStructuralFeatureAction(
					(WriteStructuralFeatureAction) value, diagnostics, context);
			case UMLPackage.CLEAR_STRUCTURAL_FEATURE_ACTION :
				return validateClearStructuralFeatureAction(
					(ClearStructuralFeatureAction) value, diagnostics, context);
			case UMLPackage.REMOVE_STRUCTURAL_FEATURE_VALUE_ACTION :
				return validateRemoveStructuralFeatureValueAction(
					(RemoveStructuralFeatureValueAction) value, diagnostics,
					context);
			case UMLPackage.ADD_STRUCTURAL_FEATURE_VALUE_ACTION :
				return validateAddStructuralFeatureValueAction(
					(AddStructuralFeatureValueAction) value, diagnostics,
					context);
			case UMLPackage.LINK_ACTION :
				return validateLinkAction((LinkAction) value, diagnostics,
					context);
			case UMLPackage.LINK_END_DATA :
				return validateLinkEndData((LinkEndData) value, diagnostics,
					context);
			case UMLPackage.QUALIFIER_VALUE :
				return validateQualifierValue((QualifierValue) value,
					diagnostics, context);
			case UMLPackage.READ_LINK_ACTION :
				return validateReadLinkAction((ReadLinkAction) value,
					diagnostics, context);
			case UMLPackage.LINK_END_CREATION_DATA :
				return validateLinkEndCreationData((LinkEndCreationData) value,
					diagnostics, context);
			case UMLPackage.CREATE_LINK_ACTION :
				return validateCreateLinkAction((CreateLinkAction) value,
					diagnostics, context);
			case UMLPackage.WRITE_LINK_ACTION :
				return validateWriteLinkAction((WriteLinkAction) value,
					diagnostics, context);
			case UMLPackage.DESTROY_LINK_ACTION :
				return validateDestroyLinkAction((DestroyLinkAction) value,
					diagnostics, context);
			case UMLPackage.LINK_END_DESTRUCTION_DATA :
				return validateLinkEndDestructionData(
					(LinkEndDestructionData) value, diagnostics, context);
			case UMLPackage.CLEAR_ASSOCIATION_ACTION :
				return validateClearAssociationAction(
					(ClearAssociationAction) value, diagnostics, context);
			case UMLPackage.BROADCAST_SIGNAL_ACTION :
				return validateBroadcastSignalAction(
					(BroadcastSignalAction) value, diagnostics, context);
			case UMLPackage.INVOCATION_ACTION :
				return validateInvocationAction((InvocationAction) value,
					diagnostics, context);
			case UMLPackage.SEND_OBJECT_ACTION :
				return validateSendObjectAction((SendObjectAction) value,
					diagnostics, context);
			case UMLPackage.VALUE_SPECIFICATION_ACTION :
				return validateValueSpecificationAction(
					(ValueSpecificationAction) value, diagnostics, context);
			case UMLPackage.TIME_EXPRESSION :
				return validateTimeExpression((TimeExpression) value,
					diagnostics, context);
			case UMLPackage.DURATION :
				return validateDuration((Duration) value, diagnostics, context);
			case UMLPackage.TIME_OBSERVATION_ACTION :
				return validateTimeObservationAction(
					(TimeObservationAction) value, diagnostics, context);
			case UMLPackage.VALUE_PIN :
				return validateValuePin((ValuePin) value, diagnostics, context);
			case UMLPackage.DURATION_INTERVAL :
				return validateDurationInterval((DurationInterval) value,
					diagnostics, context);
			case UMLPackage.INTERVAL :
				return validateInterval((Interval) value, diagnostics, context);
			case UMLPackage.TIME_CONSTRAINT :
				return validateTimeConstraint((TimeConstraint) value,
					diagnostics, context);
			case UMLPackage.INTERVAL_CONSTRAINT :
				return validateIntervalConstraint((IntervalConstraint) value,
					diagnostics, context);
			case UMLPackage.TIME_INTERVAL :
				return validateTimeInterval((TimeInterval) value, diagnostics,
					context);
			case UMLPackage.DURATION_OBSERVATION_ACTION :
				return validateDurationObservationAction(
					(DurationObservationAction) value, diagnostics, context);
			case UMLPackage.DURATION_CONSTRAINT :
				return validateDurationConstraint((DurationConstraint) value,
					diagnostics, context);
			case UMLPackage.OPAQUE_ACTION :
				return validateOpaqueAction((OpaqueAction) value, diagnostics,
					context);
			case UMLPackage.CALL_ACTION :
				return validateCallAction((CallAction) value, diagnostics,
					context);
			case UMLPackage.SEND_SIGNAL_ACTION :
				return validateSendSignalAction((SendSignalAction) value,
					diagnostics, context);
			case UMLPackage.CALL_OPERATION_ACTION :
				return validateCallOperationAction((CallOperationAction) value,
					diagnostics, context);
			case UMLPackage.CALL_BEHAVIOR_ACTION :
				return validateCallBehaviorAction((CallBehaviorAction) value,
					diagnostics, context);
			case UMLPackage.INFORMATION_ITEM :
				return validateInformationItem((InformationItem) value,
					diagnostics, context);
			case UMLPackage.INFORMATION_FLOW :
				return validateInformationFlow((InformationFlow) value,
					diagnostics, context);
			case UMLPackage.MODEL :
				return validateModel((Model) value, diagnostics, context);
			case UMLPackage.VARIABLE_ACTION :
				return validateVariableAction((VariableAction) value,
					diagnostics, context);
			case UMLPackage.READ_VARIABLE_ACTION :
				return validateReadVariableAction((ReadVariableAction) value,
					diagnostics, context);
			case UMLPackage.WRITE_VARIABLE_ACTION :
				return validateWriteVariableAction((WriteVariableAction) value,
					diagnostics, context);
			case UMLPackage.CLEAR_VARIABLE_ACTION :
				return validateClearVariableAction((ClearVariableAction) value,
					diagnostics, context);
			case UMLPackage.ADD_VARIABLE_VALUE_ACTION :
				return validateAddVariableValueAction(
					(AddVariableValueAction) value, diagnostics, context);
			case UMLPackage.REMOVE_VARIABLE_VALUE_ACTION :
				return validateRemoveVariableValueAction(
					(RemoveVariableValueAction) value, diagnostics, context);
			case UMLPackage.RAISE_EXCEPTION_ACTION :
				return validateRaiseExceptionAction(
					(RaiseExceptionAction) value, diagnostics, context);
			case UMLPackage.ACTION_INPUT_PIN :
				return validateActionInputPin((ActionInputPin) value,
					diagnostics, context);
			case UMLPackage.READ_EXTENT_ACTION :
				return validateReadExtentAction((ReadExtentAction) value,
					diagnostics, context);
			case UMLPackage.RECLASSIFY_OBJECT_ACTION :
				return validateReclassifyObjectAction(
					(ReclassifyObjectAction) value, diagnostics, context);
			case UMLPackage.READ_IS_CLASSIFIED_OBJECT_ACTION :
				return validateReadIsClassifiedObjectAction(
					(ReadIsClassifiedObjectAction) value, diagnostics, context);
			case UMLPackage.START_CLASSIFIER_BEHAVIOR_ACTION :
				return validateStartClassifierBehaviorAction(
					(StartClassifierBehaviorAction) value, diagnostics, context);
			case UMLPackage.READ_LINK_OBJECT_END_ACTION :
				return validateReadLinkObjectEndAction(
					(ReadLinkObjectEndAction) value, diagnostics, context);
			case UMLPackage.READ_LINK_OBJECT_END_QUALIFIER_ACTION :
				return validateReadLinkObjectEndQualifierAction(
					(ReadLinkObjectEndQualifierAction) value, diagnostics,
					context);
			case UMLPackage.CREATE_LINK_OBJECT_ACTION :
				return validateCreateLinkObjectAction(
					(CreateLinkObjectAction) value, diagnostics, context);
			case UMLPackage.ACCEPT_EVENT_ACTION :
				return validateAcceptEventAction((AcceptEventAction) value,
					diagnostics, context);
			case UMLPackage.ACCEPT_CALL_ACTION :
				return validateAcceptCallAction((AcceptCallAction) value,
					diagnostics, context);
			case UMLPackage.REPLY_ACTION :
				return validateReplyAction((ReplyAction) value, diagnostics,
					context);
			case UMLPackage.UNMARSHALL_ACTION :
				return validateUnmarshallAction((UnmarshallAction) value,
					diagnostics, context);
			case UMLPackage.CONTROL_NODE :
				return validateControlNode((ControlNode) value, diagnostics,
					context);
			case UMLPackage.CONTROL_FLOW :
				return validateControlFlow((ControlFlow) value, diagnostics,
					context);
			case UMLPackage.INITIAL_NODE :
				return validateInitialNode((InitialNode) value, diagnostics,
					context);
			case UMLPackage.ACTIVITY_PARAMETER_NODE :
				return validateActivityParameterNode(
					(ActivityParameterNode) value, diagnostics, context);
			case UMLPackage.FORK_NODE :
				return validateForkNode((ForkNode) value, diagnostics, context);
			case UMLPackage.FLOW_FINAL_NODE :
				return validateFlowFinalNode((FlowFinalNode) value,
					diagnostics, context);
			case UMLPackage.FINAL_NODE :
				return validateFinalNode((FinalNode) value, diagnostics,
					context);
			case UMLPackage.CENTRAL_BUFFER_NODE :
				return validateCentralBufferNode((CentralBufferNode) value,
					diagnostics, context);
			case UMLPackage.MERGE_NODE :
				return validateMergeNode((MergeNode) value, diagnostics,
					context);
			case UMLPackage.DECISION_NODE :
				return validateDecisionNode((DecisionNode) value, diagnostics,
					context);
			case UMLPackage.ACTIVITY_FINAL_NODE :
				return validateActivityFinalNode((ActivityFinalNode) value,
					diagnostics, context);
			case UMLPackage.JOIN_NODE :
				return validateJoinNode((JoinNode) value, diagnostics, context);
			case UMLPackage.DATA_STORE_NODE :
				return validateDataStoreNode((DataStoreNode) value,
					diagnostics, context);
			case UMLPackage.OBJECT_FLOW :
				return validateObjectFlow((ObjectFlow) value, diagnostics,
					context);
			case UMLPackage.SEQUENCE_NODE :
				return validateSequenceNode((SequenceNode) value, diagnostics,
					context);
			case UMLPackage.CONDITIONAL_NODE :
				return validateConditionalNode((ConditionalNode) value,
					diagnostics, context);
			case UMLPackage.CLAUSE :
				return validateClause((Clause) value, diagnostics, context);
			case UMLPackage.LOOP_NODE :
				return validateLoopNode((LoopNode) value, diagnostics, context);
			case UMLPackage.EXPANSION_NODE :
				return validateExpansionNode((ExpansionNode) value,
					diagnostics, context);
			case UMLPackage.EXPANSION_REGION :
				return validateExpansionRegion((ExpansionRegion) value,
					diagnostics, context);
			case UMLPackage.COMPONENT_REALIZATION :
				return validateComponentRealization(
					(ComponentRealization) value, diagnostics, context);
			case UMLPackage.COMPONENT :
				return validateComponent((Component) value, diagnostics,
					context);
			case UMLPackage.NODE :
				return validateNode((Node) value, diagnostics, context);
			case UMLPackage.DEVICE :
				return validateDevice((Device) value, diagnostics, context);
			case UMLPackage.EXECUTION_ENVIRONMENT :
				return validateExecutionEnvironment(
					(ExecutionEnvironment) value, diagnostics, context);
			case UMLPackage.COMMUNICATION_PATH :
				return validateCommunicationPath((CommunicationPath) value,
					diagnostics, context);
			case UMLPackage.FINAL_STATE :
				return validateFinalState((FinalState) value, diagnostics,
					context);
			case UMLPackage.TIME_EVENT :
				return validateTimeEvent((TimeEvent) value, diagnostics,
					context);
			case UMLPackage.PROTOCOL_TRANSITION :
				return validateProtocolTransition((ProtocolTransition) value,
					diagnostics, context);
			case UMLPackage.ASSOCIATION_CLASS :
				return validateAssociationClass((AssociationClass) value,
					diagnostics, context);
			case UMLPackage.VISIBILITY_KIND :
				return validateVisibilityKind((Object) value, diagnostics,
					context);
			case UMLPackage.CALL_CONCURRENCY_KIND :
				return validateCallConcurrencyKind((Object) value, diagnostics,
					context);
			case UMLPackage.TRANSITION_KIND :
				return validateTransitionKind((Object) value, diagnostics,
					context);
			case UMLPackage.PSEUDOSTATE_KIND :
				return validatePseudostateKind((Object) value, diagnostics,
					context);
			case UMLPackage.AGGREGATION_KIND :
				return validateAggregationKind((Object) value, diagnostics,
					context);
			case UMLPackage.PARAMETER_DIRECTION_KIND :
				return validateParameterDirectionKind((Object) value,
					diagnostics, context);
			case UMLPackage.PARAMETER_EFFECT_KIND :
				return validateParameterEffectKind((Object) value, diagnostics,
					context);
			case UMLPackage.CONNECTOR_KIND :
				return validateConnectorKind((Object) value, diagnostics,
					context);
			case UMLPackage.MESSAGE_KIND :
				return validateMessageKind((Object) value, diagnostics, context);
			case UMLPackage.MESSAGE_SORT :
				return validateMessageSort((Object) value, diagnostics, context);
			case UMLPackage.OBJECT_NODE_ORDERING_KIND :
				return validateObjectNodeOrderingKind((Object) value,
					diagnostics, context);
			case UMLPackage.INTERACTION_OPERATOR_KIND :
				return validateInteractionOperatorKind((Object) value,
					diagnostics, context);
			case UMLPackage.EXPANSION_KIND :
				return validateExpansionKind((Object) value, diagnostics,
					context);
			default :
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComment(Comment comment,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(comment,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(comment, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(comment, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(comment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(comment, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(comment, diagnostics,
				context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(element,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(element, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(element, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(element, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(element, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(element, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validateNotOwnSelf constraint of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement_validateNotOwnSelf(Element element,
			DiagnosticChain diagnostics, Map context) {
		return element.validateNotOwnSelf(diagnostics, context);
	}

	/**
	 * Validates the validateHasOwner constraint of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement_validateHasOwner(Element element,
			DiagnosticChain diagnostics, Map context) {
		return element.validateHasOwner(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectedRelationship(
			DirectedRelationship directedRelationship,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			directedRelationship, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(directedRelationship,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(directedRelationship,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(directedRelationship,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(directedRelationship,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(directedRelationship,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationship(Relationship relationship,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(relationship,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(relationship,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(relationship,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(relationship, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(relationship,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(relationship,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralSpecification(
			LiteralSpecification literalSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			literalSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(literalSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(literalSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(literalSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(literalSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(literalSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				literalSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				literalSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				literalSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueSpecification(
			ValueSpecification valueSpecification, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(valueSpecification,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(valueSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(valueSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(valueSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(valueSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(valueSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				valueSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				valueSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				valueSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(typedElement,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typedElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typedElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typedElement, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(typedElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(typedElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				typedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				typedElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(namedElement,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(namedElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(namedElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(namedElement, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(namedElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(namedElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				namedElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				namedElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateHasNoQualifiedName constraint of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement_validateHasNoQualifiedName(
			NamedElement namedElement, DiagnosticChain diagnostics, Map context) {
		return namedElement.validateHasNoQualifiedName(diagnostics, context);
	}

	/**
	 * Validates the validateHasQualifiedName constraint of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement_validateHasQualifiedName(
			NamedElement namedElement, DiagnosticChain diagnostics, Map context) {
		return namedElement.validateHasQualifiedName(diagnostics, context);
	}

	/**
	 * Validates the validateVisibilityNeedsOwnership constraint of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement_validateVisibilityNeedsOwnership(
			NamedElement namedElement, DiagnosticChain diagnostics, Map context) {
		return namedElement.validateVisibilityNeedsOwnership(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependency(Dependency dependency,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(dependency,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(dependency, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(dependency,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(dependency, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(dependency,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(dependency, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				dependency, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(dependency,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				dependency, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageableElement(
			PackageableElement packageableElement, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(packageableElement,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(packageableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(packageableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(packageableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(packageableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(packageableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				packageableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				packageableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				packageableElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterableElement(
			ParameterableElement parameterableElement,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			parameterableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(parameterableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(parameterableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(parameterableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(parameterableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(parameterableElement,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameter(
			TemplateParameter templateParameter, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(templateParameter,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(templateParameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(templateParameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(templateParameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(templateParameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(templateParameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateParameter_validateMustBeCompatible(
				templateParameter, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMustBeCompatible constraint of '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameter_validateMustBeCompatible(
			TemplateParameter templateParameter, DiagnosticChain diagnostics,
			Map context) {
		return templateParameter.validateMustBeCompatible(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateSignature(
			TemplateSignature templateSignature, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(templateSignature,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(templateSignature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(templateSignature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(templateSignature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(templateSignature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(templateSignature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateSignature_validateOwnElements(
				templateSignature, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOwnElements constraint of '<em>Template Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateSignature_validateOwnElements(
			TemplateSignature templateSignature, DiagnosticChain diagnostics,
			Map context) {
		return templateSignature.validateOwnElements(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateableElement(
			TemplateableElement templateableElement,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			templateableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(templateableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(templateableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(templateableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(templateableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(templateableElement,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding(TemplateBinding templateBinding,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(templateBinding,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(templateBinding,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(templateBinding,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(templateBinding, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(templateBinding,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(templateBinding,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateBinding_validateParameterSubstitutionFormal(
				templateBinding, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateBinding_validateOneParameterSubstitution(
				templateBinding, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateParameterSubstitutionFormal constraint of '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding_validateParameterSubstitutionFormal(
			TemplateBinding templateBinding, DiagnosticChain diagnostics,
			Map context) {
		return templateBinding.validateParameterSubstitutionFormal(diagnostics,
			context);
	}

	/**
	 * Validates the validateOneParameterSubstitution constraint of '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding_validateOneParameterSubstitution(
			TemplateBinding templateBinding, DiagnosticChain diagnostics,
			Map context) {
		return templateBinding.validateOneParameterSubstitution(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitution(
			TemplateParameterSubstitution templateParameterSubstitution,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateParameterSubstitution_validateMustBeCompatible(
				templateParameterSubstitution, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMustBeCompatible constraint of '<em>Template Parameter Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitution_validateMustBeCompatible(
			TemplateParameterSubstitution templateParameterSubstitution,
			DiagnosticChain diagnostics, Map context) {
		return templateParameterSubstitution.validateMustBeCompatible(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace(Namespace namespace,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(namespace,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(namespace, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(namespace,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(namespace, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(namespace,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(namespace, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(namespace,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				namespace, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				namespace, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMembersDistinguishable constraint of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace_validateMembersDistinguishable(
			Namespace namespace, DiagnosticChain diagnostics, Map context) {
		return namespace.validateMembersDistinguishable(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementImport(ElementImport elementImport,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(elementImport,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(elementImport,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(elementImport,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(elementImport, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(elementImport,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(elementImport,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElementImport_validateVisibilityPublicOrPrivate(
				elementImport, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElementImport_validateVisibilityOrPrivate(
				elementImport, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElementImport_validateImportedElementIsPublic(
				elementImport, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateVisibilityPublicOrPrivate constraint of '<em>Element Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementImport_validateVisibilityPublicOrPrivate(
			ElementImport elementImport, DiagnosticChain diagnostics,
			Map context) {
		return elementImport.validateVisibilityPublicOrPrivate(diagnostics,
			context);
	}

	/**
	 * Validates the validateVisibilityOrPrivate constraint of '<em>Element Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementImport_validateVisibilityOrPrivate(
			ElementImport elementImport, DiagnosticChain diagnostics,
			Map context) {
		return elementImport.validateVisibilityOrPrivate(diagnostics, context);
	}

	/**
	 * Validates the validateImportedElementIsPublic constraint of '<em>Element Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementImport_validateImportedElementIsPublic(
			ElementImport elementImport, DiagnosticChain diagnostics,
			Map context) {
		return elementImport.validateImportedElementIsPublic(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageImport(PackageImport packageImport,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(packageImport,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(packageImport,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(packageImport,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(packageImport, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(packageImport,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(packageImport,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePackageImport_validatePublicOrPrivate(
				packageImport, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validatePublicOrPrivate constraint of '<em>Package Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageImport_validatePublicOrPrivate(
			PackageImport packageImport, DiagnosticChain diagnostics,
			Map context) {
		return packageImport.validatePublicOrPrivate(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackage(org.eclipse.uml2.uml.Package package_,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(package_,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(package_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(package_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(package_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(package_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(package_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(package_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(package_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				package_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				package_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePackage_validateElementsPublicOrPrivate(package_,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateElementsPublicOrPrivate constraint of '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackage_validateElementsPublicOrPrivate(
			org.eclipse.uml2.uml.Package package_, DiagnosticChain diagnostics,
			Map context) {
		return package_.validateElementsPublicOrPrivate(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageMerge(PackageMerge packageMerge,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(packageMerge,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(packageMerge,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(packageMerge,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(packageMerge, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(packageMerge,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(packageMerge,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(type, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(type, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(type, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(type, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(type, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(type, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(type,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(type,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				type, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfileApplication(
			ProfileApplication profileApplication, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(profileApplication,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(profileApplication,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(profileApplication,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(profileApplication,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(profileApplication,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(profileApplication,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePackageImport_validatePublicOrPrivate(
				profileApplication, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfile(Profile profile,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(profile,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(profile, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(profile, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(profile, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(profile, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(profile, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(profile,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(profile,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				profile, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(profile,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePackage_validateElementsPublicOrPrivate(profile,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProfile_validateMetaclassReferenceNotSpecialized(
				profile, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProfile_validateReferencesSameMetamodel(profile,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMetaclassReferenceNotSpecialized constraint of '<em>Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfile_validateMetaclassReferenceNotSpecialized(
			Profile profile, DiagnosticChain diagnostics, Map context) {
		return profile.validateMetaclassReferenceNotSpecialized(diagnostics,
			context);
	}

	/**
	 * Validates the validateReferencesSameMetamodel constraint of '<em>Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProfile_validateReferencesSameMetamodel(
			Profile profile, DiagnosticChain diagnostics, Map context) {
		return profile.validateReferencesSameMetamodel(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotype(Stereotype stereotype,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(stereotype,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(stereotype, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(stereotype,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(stereotype, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(stereotype,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(stereotype, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(stereotype,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(stereotype,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				stereotype, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(stereotype,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStereotype_validateNameNotClash(stereotype,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStereotype_validateGeneralize(stereotype,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNameNotClash constraint of '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotype_validateNameNotClash(
			Stereotype stereotype, DiagnosticChain diagnostics, Map context) {
		return stereotype.validateNameNotClash(diagnostics, context);
	}

	/**
	 * Validates the validateGeneralize constraint of '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStereotype_validateGeneralize(Stereotype stereotype,
			DiagnosticChain diagnostics, Map context) {
		return stereotype.validateGeneralize(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass(org.eclipse.uml2.uml.Class class_,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(class_,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(class_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(class_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(class_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(class_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(class_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(class_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(class_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(class_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				class_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(class_, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validatePassiveClass constraint of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass_validatePassiveClass(
			org.eclipse.uml2.uml.Class class_, DiagnosticChain diagnostics,
			Map context) {
		return class_.validatePassiveClass(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioredClassifier(
			BehavioredClassifier behavioredClassifier,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(behavioredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(behavioredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(behavioredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(behavioredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(behavioredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				behavioredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				behavioredClassifier, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateClassBehavior constraint of '<em>Behaviored Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioredClassifier_validateClassBehavior(
			BehavioredClassifier behavioredClassifier,
			DiagnosticChain diagnostics, Map context) {
		return behavioredClassifier.validateClassBehavior(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier(Classifier classifier,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(classifier,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(classifier, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(classifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(classifier, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(classifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(classifier, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(classifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				classifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(classifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				classifier, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoCyclesInGeneralization constraint of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier_validateNoCyclesInGeneralization(
			Classifier classifier, DiagnosticChain diagnostics, Map context) {
		return classifier
			.validateNoCyclesInGeneralization(diagnostics, context);
	}

	/**
	 * Validates the validateSpecializeType constraint of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier_validateSpecializeType(
			Classifier classifier, DiagnosticChain diagnostics, Map context) {
		return classifier.validateSpecializeType(diagnostics, context);
	}

	/**
	 * Validates the validateGeneralizationHierarchies constraint of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier_validateGeneralizationHierarchies(
			Classifier classifier, DiagnosticChain diagnostics, Map context) {
		return classifier.validateGeneralizationHierarchies(diagnostics,
			context);
	}

	/**
	 * Validates the validateMapsToGeneralizationSet constraint of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifier_validateMapsToGeneralizationSet(
			Classifier classifier, DiagnosticChain diagnostics, Map context) {
		return classifier.validateMapsToGeneralizationSet(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedefinableElement(
			RedefinableElement redefinableElement, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(redefinableElement,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(redefinableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(redefinableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(redefinableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(redefinableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(redefinableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				redefinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				redefinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				redefinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				redefinableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				redefinableElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateRedefinitionContextValid constraint of '<em>Redefinable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedefinableElement_validateRedefinitionContextValid(
			RedefinableElement redefinableElement, DiagnosticChain diagnostics,
			Map context) {
		return redefinableElement.validateRedefinitionContextValid(diagnostics,
			context);
	}

	/**
	 * Validates the validateRedefinitionConsistent constraint of '<em>Redefinable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedefinableElement_validateRedefinitionConsistent(
			RedefinableElement redefinableElement, DiagnosticChain diagnostics,
			Map context) {
		return redefinableElement.validateRedefinitionConsistent(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralization(Generalization generalization,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(generalization,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(generalization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(generalization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(generalization, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(generalization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(generalization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateGeneralization_validateGeneralizationSameClassifier(
				generalization, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateGeneralizationSameClassifier constraint of '<em>Generalization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralization_validateGeneralizationSameClassifier(
			Generalization generalization, DiagnosticChain diagnostics,
			Map context) {
		return generalization.validateGeneralizationSameClassifier(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralizationSet(
			GeneralizationSet generalizationSet, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(generalizationSet,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(generalizationSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(generalizationSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(generalizationSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(generalizationSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(generalizationSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				generalizationSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				generalizationSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				generalizationSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateGeneralizationSet_validateGeneralizationSameClassifier(
				generalizationSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateGeneralizationSet_validateMapsToGeneralizationSet(
				generalizationSet, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateGeneralizationSameClassifier constraint of '<em>Generalization Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralizationSet_validateGeneralizationSameClassifier(
			GeneralizationSet generalizationSet, DiagnosticChain diagnostics,
			Map context) {
		return generalizationSet.validateGeneralizationSameClassifier(
			diagnostics, context);
	}

	/**
	 * Validates the validateMapsToGeneralizationSet constraint of '<em>Generalization Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralizationSet_validateMapsToGeneralizationSet(
			GeneralizationSet generalizationSet, DiagnosticChain diagnostics,
			Map context) {
		return generalizationSet.validateMapsToGeneralizationSet(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature(Feature feature,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(feature,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(feature, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(feature, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(feature, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(feature, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(feature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(feature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				feature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				feature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase(UseCase useCase,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(useCase,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(useCase, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(useCase, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(useCase, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(useCase, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(useCase, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(useCase,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(useCase,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				useCase, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(useCase,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				useCase, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				useCase, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				useCase, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				useCase, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(useCase,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				useCase, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				useCase, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUseCase_validateMustHaveName(useCase,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUseCase_validateBinaryAssociations(useCase,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUseCase_validateNoAssociationToUseCase(useCase,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUseCase_validateCannotIncludeSelf(useCase,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMustHaveName constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_validateMustHaveName(UseCase useCase,
			DiagnosticChain diagnostics, Map context) {
		return useCase.validateMustHaveName(diagnostics, context);
	}

	/**
	 * Validates the validateBinaryAssociations constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_validateBinaryAssociations(UseCase useCase,
			DiagnosticChain diagnostics, Map context) {
		return useCase.validateBinaryAssociations(diagnostics, context);
	}

	/**
	 * Validates the validateNoAssociationToUseCase constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_validateNoAssociationToUseCase(
			UseCase useCase, DiagnosticChain diagnostics, Map context) {
		return useCase.validateNoAssociationToUseCase(diagnostics, context);
	}

	/**
	 * Validates the validateCannotIncludeSelf constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_validateCannotIncludeSelf(UseCase useCase,
			DiagnosticChain diagnostics, Map context) {
		return useCase.validateCannotIncludeSelf(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInclude(Include include,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(include,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(include, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(include, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(include, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(include, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(include, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(include,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(include,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				include, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtend(Extend extend, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(extend,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(extend, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(extend, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(extend, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(extend, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(extend, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(extend,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(extend,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				extend, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExtend_validateExtensionPoints(extend,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateExtensionPoints constraint of '<em>Extend</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtend_validateExtensionPoints(Extend extend,
			DiagnosticChain diagnostics, Map context) {
		return extend.validateExtensionPoints(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(constraint,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(constraint, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(constraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(constraint, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(constraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(constraint, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				constraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(constraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				constraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotApplyToSelf(constraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateValueSpecificationBoolean(
				constraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateBooleanValue(constraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNoSideEffects(constraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotAppliedToSelf(constraint,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNotApplyToSelf constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateNotApplyToSelf(
			Constraint constraint, DiagnosticChain diagnostics, Map context) {
		return constraint.validateNotApplyToSelf(diagnostics, context);
	}

	/**
	 * Validates the validateValueSpecificationBoolean constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateValueSpecificationBoolean(
			Constraint constraint, DiagnosticChain diagnostics, Map context) {
		return constraint.validateValueSpecificationBoolean(diagnostics,
			context);
	}

	/**
	 * Validates the validateBooleanValue constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateBooleanValue(
			Constraint constraint, DiagnosticChain diagnostics, Map context) {
		return constraint.validateBooleanValue(diagnostics, context);
	}

	/**
	 * Validates the validateNoSideEffects constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateNoSideEffects(
			Constraint constraint, DiagnosticChain diagnostics, Map context) {
		return constraint.validateNoSideEffects(diagnostics, context);
	}

	/**
	 * Validates the validateNotAppliedToSelf constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateNotAppliedToSelf(
			Constraint constraint, DiagnosticChain diagnostics, Map context) {
		return constraint.validateNotAppliedToSelf(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtensionPoint(ExtensionPoint extensionPoint,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(extensionPoint,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(extensionPoint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(extensionPoint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(extensionPoint, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(extensionPoint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(extensionPoint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				extensionPoint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				extensionPoint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				extensionPoint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				extensionPoint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				extensionPoint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExtensionPoint_validateMustHaveName(
				extensionPoint, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMustHaveName constraint of '<em>Extension Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtensionPoint_validateMustHaveName(
			ExtensionPoint extensionPoint, DiagnosticChain diagnostics,
			Map context) {
		return extensionPoint.validateMustHaveName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubstitution(Substitution substitution,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(substitution,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(substitution,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(substitution,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(substitution, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(substitution,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(substitution,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				substitution, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				substitution, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				substitution, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealization(Realization realization,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(realization,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(realization, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(realization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(realization, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(realization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(realization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				realization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				realization, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstraction(Abstraction abstraction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(abstraction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(abstraction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(abstraction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(abstraction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(abstraction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(abstraction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				abstraction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				abstraction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				abstraction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueExpression(OpaqueExpression opaqueExpression,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(opaqueExpression,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(opaqueExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(opaqueExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(opaqueExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(opaqueExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(opaqueExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				opaqueExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				opaqueExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				opaqueExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOpaqueExpression_validateLanguageBodySize(
				opaqueExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOpaqueExpression_validateOneBodyDefaultLanguage(
				opaqueExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOpaqueExpression_validateOnlyReturnResultParameters(
				opaqueExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOpaqueExpression_validateOneReturnResultParameter(
				opaqueExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateLanguageBodySize constraint of '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueExpression_validateLanguageBodySize(
			OpaqueExpression opaqueExpression, DiagnosticChain diagnostics,
			Map context) {
		return opaqueExpression.validateLanguageBodySize(diagnostics, context);
	}

	/**
	 * Validates the validateOneBodyDefaultLanguage constraint of '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueExpression_validateOneBodyDefaultLanguage(
			OpaqueExpression opaqueExpression, DiagnosticChain diagnostics,
			Map context) {
		return opaqueExpression.validateOneBodyDefaultLanguage(diagnostics,
			context);
	}

	/**
	 * Validates the validateOnlyReturnResultParameters constraint of '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueExpression_validateOnlyReturnResultParameters(
			OpaqueExpression opaqueExpression, DiagnosticChain diagnostics,
			Map context) {
		return opaqueExpression.validateOnlyReturnResultParameters(diagnostics,
			context);
	}

	/**
	 * Validates the validateOneReturnResultParameter constraint of '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueExpression_validateOneReturnResultParameter(
			OpaqueExpression opaqueExpression, DiagnosticChain diagnostics,
			Map context) {
		return opaqueExpression.validateOneReturnResultParameter(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(parameter,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(parameter, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(parameter, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(parameter, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGt0(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateLowerGe0(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGeLower(
				parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationNoSideEffects(
				parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationConstant(
				parameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateParameter_validateConnectorEnd(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateParameter_validateStreamAndException(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateParameter_validateNotException(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateParameter_validateReentrantBehaviors(parameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateParameter_validateInAndOut(parameter,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateConnectorEnd constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_validateConnectorEnd(Parameter parameter,
			DiagnosticChain diagnostics, Map context) {
		return parameter.validateConnectorEnd(diagnostics, context);
	}

	/**
	 * Validates the validateStreamAndException constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_validateStreamAndException(
			Parameter parameter, DiagnosticChain diagnostics, Map context) {
		return parameter.validateStreamAndException(diagnostics, context);
	}

	/**
	 * Validates the validateNotException constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_validateNotException(Parameter parameter,
			DiagnosticChain diagnostics, Map context) {
		return parameter.validateNotException(diagnostics, context);
	}

	/**
	 * Validates the validateReentrantBehaviors constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_validateReentrantBehaviors(
			Parameter parameter, DiagnosticChain diagnostics, Map context) {
		return parameter.validateReentrantBehaviors(diagnostics, context);
	}

	/**
	 * Validates the validateInAndOut constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_validateInAndOut(Parameter parameter,
			DiagnosticChain diagnostics, Map context) {
		return parameter.validateInAndOut(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			multiplicityElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(multiplicityElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(multiplicityElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(multiplicityElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(multiplicityElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(multiplicityElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGt0(
				multiplicityElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateLowerGe0(
				multiplicityElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGeLower(
				multiplicityElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationNoSideEffects(
				multiplicityElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationConstant(
				multiplicityElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateUpperGt0 constraint of '<em>Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement_validateUpperGt0(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map context) {
		return multiplicityElement.validateUpperGt0(diagnostics, context);
	}

	/**
	 * Validates the validateLowerGe0 constraint of '<em>Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement_validateLowerGe0(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map context) {
		return multiplicityElement.validateLowerGe0(diagnostics, context);
	}

	/**
	 * Validates the validateUpperGeLower constraint of '<em>Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement_validateUpperGeLower(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map context) {
		return multiplicityElement.validateUpperGeLower(diagnostics, context);
	}

	/**
	 * Validates the validateValueSpecificationNoSideEffects constraint of '<em>Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement_validateValueSpecificationNoSideEffects(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map context) {
		return multiplicityElement.validateValueSpecificationNoSideEffects(
			diagnostics, context);
	}

	/**
	 * Validates the validateValueSpecificationConstant constraint of '<em>Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement_validateValueSpecificationConstant(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map context) {
		return multiplicityElement.validateValueSpecificationConstant(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectableElement(
			ConnectableElement connectableElement, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(connectableElement,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(connectableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(connectableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(connectableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(connectableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(connectableElement,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				connectableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				connectableElement, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				connectableElement, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectorEnd(ConnectorEnd connectorEnd,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(connectorEnd,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(connectorEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(connectorEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(connectorEnd, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(connectorEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(connectorEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGt0(
				connectorEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateLowerGe0(
				connectorEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGeLower(
				connectorEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationNoSideEffects(
				connectorEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationConstant(
				connectorEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnectorEnd_validateMultiplicity(connectorEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnectorEnd_validatePartWithPortEmpty(
				connectorEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnectorEnd_validateRoleAndPartWithPort(
				connectorEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnectorEnd_validateSelfPartWithPort(
				connectorEnd, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Connector End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectorEnd_validateMultiplicity(
			ConnectorEnd connectorEnd, DiagnosticChain diagnostics, Map context) {
		return connectorEnd.validateMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the validatePartWithPortEmpty constraint of '<em>Connector End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectorEnd_validatePartWithPortEmpty(
			ConnectorEnd connectorEnd, DiagnosticChain diagnostics, Map context) {
		return connectorEnd.validatePartWithPortEmpty(diagnostics, context);
	}

	/**
	 * Validates the validateRoleAndPartWithPort constraint of '<em>Connector End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectorEnd_validateRoleAndPartWithPort(
			ConnectorEnd connectorEnd, DiagnosticChain diagnostics, Map context) {
		return connectorEnd.validateRoleAndPartWithPort(diagnostics, context);
	}

	/**
	 * Validates the validateSelfPartWithPort constraint of '<em>Connector End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectorEnd_validateSelfPartWithPort(
			ConnectorEnd connectorEnd, DiagnosticChain diagnostics, Map context) {
		return connectorEnd.validateSelfPartWithPort(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(property,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(property, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(property, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(property, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(property, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(property, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGt0(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateLowerGe0(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGeLower(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationNoSideEffects(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationConstant(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateMultiplicityOfComposite(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateSubsettingContextConforms(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateNavigablePropertyRedefinition(
				property, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateSubsettingRules(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateNavigableReadonly(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDerivedUnionIsDerived(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDerivedUnionIsReadOnly(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDeploymentTarget(property,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateBindingToAttribute(property,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMultiplicityOfComposite constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateMultiplicityOfComposite(
			Property property, DiagnosticChain diagnostics, Map context) {
		return property.validateMultiplicityOfComposite(diagnostics, context);
	}

	/**
	 * Validates the validateSubsettingContextConforms constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateSubsettingContextConforms(
			Property property, DiagnosticChain diagnostics, Map context) {
		return property.validateSubsettingContextConforms(diagnostics, context);
	}

	/**
	 * Validates the validateNavigablePropertyRedefinition constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateNavigablePropertyRedefinition(
			Property property, DiagnosticChain diagnostics, Map context) {
		return property.validateNavigablePropertyRedefinition(diagnostics,
			context);
	}

	/**
	 * Validates the validateSubsettingRules constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateSubsettingRules(Property property,
			DiagnosticChain diagnostics, Map context) {
		return property.validateSubsettingRules(diagnostics, context);
	}

	/**
	 * Validates the validateNavigableReadonly constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateNavigableReadonly(
			Property property, DiagnosticChain diagnostics, Map context) {
		return property.validateNavigableReadonly(diagnostics, context);
	}

	/**
	 * Validates the validateDerivedUnionIsDerived constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateDerivedUnionIsDerived(
			Property property, DiagnosticChain diagnostics, Map context) {
		return property.validateDerivedUnionIsDerived(diagnostics, context);
	}

	/**
	 * Validates the validateDerivedUnionIsReadOnly constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateDerivedUnionIsReadOnly(
			Property property, DiagnosticChain diagnostics, Map context) {
		return property.validateDerivedUnionIsReadOnly(diagnostics, context);
	}

	/**
	 * Validates the validateDeploymentTarget constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateDeploymentTarget(Property property,
			DiagnosticChain diagnostics, Map context) {
		return property.validateDeploymentTarget(diagnostics, context);
	}

	/**
	 * Validates the validateBindingToAttribute constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateBindingToAttribute(
			Property property, DiagnosticChain diagnostics, Map context) {
		return property.validateBindingToAttribute(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeploymentTarget(DeploymentTarget deploymentTarget,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(deploymentTarget,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(deploymentTarget,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(deploymentTarget,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(deploymentTarget,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(deploymentTarget,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(deploymentTarget,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				deploymentTarget, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				deploymentTarget, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				deploymentTarget, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeployment(Deployment deployment,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(deployment,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(deployment, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(deployment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(deployment, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(deployment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(deployment, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				deployment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(deployment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				deployment, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeployedArtifact(DeployedArtifact deployedArtifact,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(deployedArtifact,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(deployedArtifact,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(deployedArtifact,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(deployedArtifact,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(deployedArtifact,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(deployedArtifact,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				deployedArtifact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				deployedArtifact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				deployedArtifact, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeploymentSpecification(
			DeploymentSpecification deploymentSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(deploymentSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(deploymentSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(deploymentSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDeploymentSpecification_validateDeployedElements(
				deploymentSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDeploymentSpecification_validateDeploymentTarget(
				deploymentSpecification, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDeployedElements constraint of '<em>Deployment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeploymentSpecification_validateDeployedElements(
			DeploymentSpecification deploymentSpecification,
			DiagnosticChain diagnostics, Map context) {
		return deploymentSpecification.validateDeployedElements(diagnostics,
			context);
	}

	/**
	 * Validates the validateDeploymentTarget constraint of '<em>Deployment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeploymentSpecification_validateDeploymentTarget(
			DeploymentSpecification deploymentSpecification,
			DiagnosticChain diagnostics, Map context) {
		return deploymentSpecification.validateDeploymentTarget(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArtifact(Artifact artifact,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(artifact,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(artifact, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(artifact, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(artifact, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(artifact, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(artifact, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(artifact,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(artifact,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				artifact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				artifact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				artifact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				artifact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				artifact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				artifact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(artifact,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				artifact, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateManifestation(Manifestation manifestation,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(manifestation,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(manifestation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(manifestation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(manifestation, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(manifestation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(manifestation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				manifestation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				manifestation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				manifestation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(operation,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(operation, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(operation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(operation, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(operation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(operation, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(operation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				operation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOperation_validateAtMostOneReturn(operation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOperation_validateOnlyBodyForQuery(operation,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateAtMostOneReturn constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateAtMostOneReturn(
			Operation operation, DiagnosticChain diagnostics, Map context) {
		return operation.validateAtMostOneReturn(diagnostics, context);
	}

	/**
	 * Validates the validateOnlyBodyForQuery constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateOnlyBodyForQuery(
			Operation operation, DiagnosticChain diagnostics, Map context) {
		return operation.validateOnlyBodyForQuery(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavioralFeature(
			BehavioralFeature behavioralFeature, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(behavioralFeature,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(behavioralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(behavioralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(behavioralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(behavioralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(behavioralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				behavioralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				behavioralFeature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavior(Behavior behavior,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(behavior,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(behavior, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(behavior, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(behavior, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(behavior, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(behavior, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(behavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(behavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(behavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(behavior, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateParametersMatch(behavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateFeatureOfContextClassifier(
				behavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMustRealize(behavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMostOneBehaviour(behavior,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateParametersMatch constraint of '<em>Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavior_validateParametersMatch(Behavior behavior,
			DiagnosticChain diagnostics, Map context) {
		return behavior.validateParametersMatch(diagnostics, context);
	}

	/**
	 * Validates the validateFeatureOfContextClassifier constraint of '<em>Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavior_validateFeatureOfContextClassifier(
			Behavior behavior, DiagnosticChain diagnostics, Map context) {
		return behavior
			.validateFeatureOfContextClassifier(diagnostics, context);
	}

	/**
	 * Validates the validateMustRealize constraint of '<em>Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavior_validateMustRealize(Behavior behavior,
			DiagnosticChain diagnostics, Map context) {
		return behavior.validateMustRealize(diagnostics, context);
	}

	/**
	 * Validates the validateMostOneBehaviour constraint of '<em>Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehavior_validateMostOneBehaviour(Behavior behavior,
			DiagnosticChain diagnostics, Map context) {
		return behavior.validateMostOneBehaviour(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterSet(ParameterSet parameterSet,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(parameterSet,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(parameterSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(parameterSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(parameterSet, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(parameterSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(parameterSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				parameterSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				parameterSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				parameterSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateParameterSet_validateSameParameterizedEntity(
				parameterSet, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateParameterSet_validateInput(parameterSet,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateParameterSet_validateTwoParameterSets(
				parameterSet, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSameParameterizedEntity constraint of '<em>Parameter Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterSet_validateSameParameterizedEntity(
			ParameterSet parameterSet, DiagnosticChain diagnostics, Map context) {
		return parameterSet.validateSameParameterizedEntity(diagnostics,
			context);
	}

	/**
	 * Validates the validateInput constraint of '<em>Parameter Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterSet_validateInput(
			ParameterSet parameterSet, DiagnosticChain diagnostics, Map context) {
		return parameterSet.validateInput(diagnostics, context);
	}

	/**
	 * Validates the validateTwoParameterSets constraint of '<em>Parameter Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterSet_validateTwoParameterSets(
			ParameterSet parameterSet, DiagnosticChain diagnostics, Map context) {
		return parameterSet.validateTwoParameterSets(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(dataType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(dataType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(dataType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(dataType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(dataType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(dataType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(dataType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(dataType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				dataType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(dataType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				dataType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterface(Interface interface_,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(interface_,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interface_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interface_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interface_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(interface_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(interface_, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(interface_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(interface_,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				interface_, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInterface_validateVisibility(interface_,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateVisibility constraint of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterface_validateVisibility(Interface interface_,
			DiagnosticChain diagnostics, Map context) {
		return interface_.validateVisibility(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReception(Reception reception,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(reception,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(reception, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(reception,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(reception, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(reception,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(reception, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				reception, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(reception,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				reception, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				reception, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				reception, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				reception, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReception_validateNotQuery(reception,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNotQuery constraint of '<em>Reception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReception_validateNotQuery(Reception reception,
			DiagnosticChain diagnostics, Map context) {
		return reception.validateNotQuery(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignal(Signal signal, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(signal,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(signal, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(signal, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(signal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(signal, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(signal, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(signal,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(signal,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				signal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(signal,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				signal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				signal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				signal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				signal, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(signal,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				signal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolStateMachine(
			ProtocolStateMachine protocolStateMachine,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(protocolStateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(protocolStateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(protocolStateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(protocolStateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(protocolStateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(protocolStateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateParametersMatch(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateFeatureOfContextClassifier(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMustRealize(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMostOneBehaviour(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProtocolStateMachine_validateClassifierContext(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStateMachine_validateContextClassifier(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStateMachine_validateConnectionPoints(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStateMachine_validateMethod(protocolStateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProtocolStateMachine_validateProtocolTransitions(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProtocolStateMachine_validateEntryExitDo(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProtocolStateMachine_validateDeepOrShallowHistory(
				protocolStateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProtocolStateMachine_validatePortsConnected(
				protocolStateMachine, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateProtocolTransitions constraint of '<em>Protocol State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolStateMachine_validateProtocolTransitions(
			ProtocolStateMachine protocolStateMachine,
			DiagnosticChain diagnostics, Map context) {
		return protocolStateMachine.validateProtocolTransitions(diagnostics,
			context);
	}

	/**
	 * Validates the validateEntryExitDo constraint of '<em>Protocol State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolStateMachine_validateEntryExitDo(
			ProtocolStateMachine protocolStateMachine,
			DiagnosticChain diagnostics, Map context) {
		return protocolStateMachine.validateEntryExitDo(diagnostics, context);
	}

	/**
	 * Validates the validateDeepOrShallowHistory constraint of '<em>Protocol State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolStateMachine_validateDeepOrShallowHistory(
			ProtocolStateMachine protocolStateMachine,
			DiagnosticChain diagnostics, Map context) {
		return protocolStateMachine.validateDeepOrShallowHistory(diagnostics,
			context);
	}

	/**
	 * Validates the validatePortsConnected constraint of '<em>Protocol State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolStateMachine_validatePortsConnected(
			ProtocolStateMachine protocolStateMachine,
			DiagnosticChain diagnostics, Map context) {
		return protocolStateMachine
			.validatePortsConnected(diagnostics, context);
	}

	/**
	 * Validates the validateClassifierContext constraint of '<em>Protocol State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolStateMachine_validateClassifierContext(
			ProtocolStateMachine protocolStateMachine,
			DiagnosticChain diagnostics, Map context) {
		// TODO override the constraint, if desired
		// -> uncomment the scaffolding
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericConstraint_diagnostic", new Object[]{"validateClassifierContext", getObjectLabel(protocolStateMachine, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{protocolStateMachine}));
			}
			return false;
		}
		return validateStateMachine_validateClassifierContext(
			protocolStateMachine, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateMachine(StateMachine stateMachine,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(stateMachine,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(stateMachine, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateParametersMatch(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateFeatureOfContextClassifier(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMustRealize(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMostOneBehaviour(stateMachine,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStateMachine_validateClassifierContext(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStateMachine_validateContextClassifier(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStateMachine_validateConnectionPoints(
				stateMachine, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStateMachine_validateMethod(stateMachine,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateClassifierContext constraint of '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateMachine_validateClassifierContext(
			StateMachine stateMachine, DiagnosticChain diagnostics, Map context) {
		return stateMachine.validateClassifierContext(diagnostics, context);
	}

	/**
	 * Validates the validateContextClassifier constraint of '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateMachine_validateContextClassifier(
			StateMachine stateMachine, DiagnosticChain diagnostics, Map context) {
		return stateMachine.validateContextClassifier(diagnostics, context);
	}

	/**
	 * Validates the validateConnectionPoints constraint of '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateMachine_validateConnectionPoints(
			StateMachine stateMachine, DiagnosticChain diagnostics, Map context) {
		return stateMachine.validateConnectionPoints(diagnostics, context);
	}

	/**
	 * Validates the validateMethod constraint of '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateMachine_validateMethod(
			StateMachine stateMachine, DiagnosticChain diagnostics, Map context) {
		return stateMachine.validateMethod(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegion(Region region, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(region,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(region, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(region, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(region, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(region, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(region, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(region,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(region,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				region, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(region,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				region, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				region, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRegion_validateInitialVertex(region, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateRegion_validateDeepHistoryVertex(region,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRegion_validateShallowHistoryVertex(region,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRegion_validateOwned(region, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInitialVertex constraint of '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegion_validateInitialVertex(Region region,
			DiagnosticChain diagnostics, Map context) {
		return region.validateInitialVertex(diagnostics, context);
	}

	/**
	 * Validates the validateDeepHistoryVertex constraint of '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegion_validateDeepHistoryVertex(Region region,
			DiagnosticChain diagnostics, Map context) {
		return region.validateDeepHistoryVertex(diagnostics, context);
	}

	/**
	 * Validates the validateShallowHistoryVertex constraint of '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegion_validateShallowHistoryVertex(Region region,
			DiagnosticChain diagnostics, Map context) {
		return region.validateShallowHistoryVertex(diagnostics, context);
	}

	/**
	 * Validates the validateOwned constraint of '<em>Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegion_validateOwned(Region region,
			DiagnosticChain diagnostics, Map context) {
		return region.validateOwned(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex(Vertex vertex, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(vertex,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(vertex, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(vertex, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(vertex, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(vertex, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(vertex, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(vertex,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(vertex,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				vertex, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition(Transition transition,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(transition,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(transition, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(transition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(transition, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(transition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(transition, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				transition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(transition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				transition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				transition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				transition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateForkSegmentGuards(transition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateJoinSegmentGuards(transition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateForkSegmentState(transition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateJoinSegmentState(transition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateOutgoingPseudostates(
				transition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateInitialTransition(transition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateSignaturesCompatible(
				transition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateForkSegmentGuards constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition_validateForkSegmentGuards(
			Transition transition, DiagnosticChain diagnostics, Map context) {
		return transition.validateForkSegmentGuards(diagnostics, context);
	}

	/**
	 * Validates the validateJoinSegmentGuards constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition_validateJoinSegmentGuards(
			Transition transition, DiagnosticChain diagnostics, Map context) {
		return transition.validateJoinSegmentGuards(diagnostics, context);
	}

	/**
	 * Validates the validateForkSegmentState constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition_validateForkSegmentState(
			Transition transition, DiagnosticChain diagnostics, Map context) {
		return transition.validateForkSegmentState(diagnostics, context);
	}

	/**
	 * Validates the validateJoinSegmentState constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition_validateJoinSegmentState(
			Transition transition, DiagnosticChain diagnostics, Map context) {
		return transition.validateJoinSegmentState(diagnostics, context);
	}

	/**
	 * Validates the validateOutgoingPseudostates constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition_validateOutgoingPseudostates(
			Transition transition, DiagnosticChain diagnostics, Map context) {
		return transition.validateOutgoingPseudostates(diagnostics, context);
	}

	/**
	 * Validates the validateInitialTransition constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition_validateInitialTransition(
			Transition transition, DiagnosticChain diagnostics, Map context) {
		return transition.validateInitialTransition(diagnostics, context);
	}

	/**
	 * Validates the validateSignaturesCompatible constraint of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition_validateSignaturesCompatible(
			Transition transition, DiagnosticChain diagnostics, Map context) {
		return transition.validateSignaturesCompatible(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTrigger(Trigger trigger,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(trigger,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(trigger, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(trigger, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(trigger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(trigger, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(trigger, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(trigger,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(trigger,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				trigger, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvent(Event event, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(event, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(event, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(event, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(event, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(event, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(event, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(event,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(event,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				event, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(port, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(port, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(port, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(port, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(port, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGt0(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateLowerGe0(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGeLower(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationNoSideEffects(
				port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationConstant(
				port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateMultiplicityOfComposite(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateSubsettingContextConforms(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateNavigablePropertyRedefinition(
				port, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateSubsettingRules(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateNavigableReadonly(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDerivedUnionIsDerived(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDerivedUnionIsReadOnly(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDeploymentTarget(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateBindingToAttribute(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePort_validateRequiredInterfaces(port,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePort_validatePortAggregation(port, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validatePort_validatePortDestroyed(port, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validatePort_validateDefaultValue(port, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validateRequiredInterfaces constraint of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort_validateRequiredInterfaces(Port port,
			DiagnosticChain diagnostics, Map context) {
		return port.validateRequiredInterfaces(diagnostics, context);
	}

	/**
	 * Validates the validatePortAggregation constraint of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort_validatePortAggregation(Port port,
			DiagnosticChain diagnostics, Map context) {
		return port.validatePortAggregation(diagnostics, context);
	}

	/**
	 * Validates the validatePortDestroyed constraint of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort_validatePortDestroyed(Port port,
			DiagnosticChain diagnostics, Map context) {
		return port.validatePortDestroyed(diagnostics, context);
	}

	/**
	 * Validates the validateDefaultValue constraint of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort_validateDefaultValue(Port port,
			DiagnosticChain diagnostics, Map context) {
		return port.validateDefaultValue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState(State state, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(state, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(state, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(state, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(state, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(state, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(state, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(state,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(state,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				state, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(state,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				state, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				state, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateRegions(state, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateSubmachineStates(state,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateDestinationsOrSourcesOfTransitions(
				state, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateSubmachineOrRegions(state,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateCompositeStates(state, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateState_validateEntryOrExit(state, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validateRegions constraint of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState_validateRegions(State state,
			DiagnosticChain diagnostics, Map context) {
		return state.validateRegions(diagnostics, context);
	}

	/**
	 * Validates the validateSubmachineStates constraint of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState_validateSubmachineStates(State state,
			DiagnosticChain diagnostics, Map context) {
		return state.validateSubmachineStates(diagnostics, context);
	}

	/**
	 * Validates the validateDestinationsOrSourcesOfTransitions constraint of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState_validateDestinationsOrSourcesOfTransitions(
			State state, DiagnosticChain diagnostics, Map context) {
		return state.validateDestinationsOrSourcesOfTransitions(diagnostics,
			context);
	}

	/**
	 * Validates the validateSubmachineOrRegions constraint of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState_validateSubmachineOrRegions(State state,
			DiagnosticChain diagnostics, Map context) {
		return state.validateSubmachineOrRegions(diagnostics, context);
	}

	/**
	 * Validates the validateCompositeStates constraint of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState_validateCompositeStates(State state,
			DiagnosticChain diagnostics, Map context) {
		return state.validateCompositeStates(diagnostics, context);
	}

	/**
	 * Validates the validateEntryOrExit constraint of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState_validateEntryOrExit(State state,
			DiagnosticChain diagnostics, Map context) {
		return state.validateEntryOrExit(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionPointReference(
			ConnectionPointReference connectionPointReference,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			connectionPointReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(connectionPointReference,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				connectionPointReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(connectionPointReference,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				connectionPointReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				connectionPointReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				connectionPointReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				connectionPointReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				connectionPointReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnectionPointReference_validateEntryPseudostates(
				connectionPointReference, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnectionPointReference_validateExitPseudostates(
				connectionPointReference, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateEntryPseudostates constraint of '<em>Connection Point Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionPointReference_validateEntryPseudostates(
			ConnectionPointReference connectionPointReference,
			DiagnosticChain diagnostics, Map context) {
		return connectionPointReference.validateEntryPseudostates(diagnostics,
			context);
	}

	/**
	 * Validates the validateExitPseudostates constraint of '<em>Connection Point Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionPointReference_validateExitPseudostates(
			ConnectionPointReference connectionPointReference,
			DiagnosticChain diagnostics, Map context) {
		return connectionPointReference.validateExitPseudostates(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate(Pseudostate pseudostate,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(pseudostate,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(pseudostate, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(pseudostate, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				pseudostate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				pseudostate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				pseudostate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateInitialVertex(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateHistoryVertices(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateJoinVertex(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateTransitionsIncoming(
				pseudostate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateForkVertex(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateTransitionsOutgoing(
				pseudostate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateJunctionVertex(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateChoiceVertex(pseudostate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePseudostate_validateOutgoingFromInitial(
				pseudostate, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInitialVertex constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateInitialVertex(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateInitialVertex(diagnostics, context);
	}

	/**
	 * Validates the validateHistoryVertices constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateHistoryVertices(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateHistoryVertices(diagnostics, context);
	}

	/**
	 * Validates the validateJoinVertex constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateJoinVertex(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateJoinVertex(diagnostics, context);
	}

	/**
	 * Validates the validateTransitionsIncoming constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateTransitionsIncoming(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateTransitionsIncoming(diagnostics, context);
	}

	/**
	 * Validates the validateForkVertex constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateForkVertex(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateForkVertex(diagnostics, context);
	}

	/**
	 * Validates the validateTransitionsOutgoing constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateTransitionsOutgoing(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateTransitionsOutgoing(diagnostics, context);
	}

	/**
	 * Validates the validateJunctionVertex constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateJunctionVertex(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateJunctionVertex(diagnostics, context);
	}

	/**
	 * Validates the validateChoiceVertex constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateChoiceVertex(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateChoiceVertex(diagnostics, context);
	}

	/**
	 * Validates the validateOutgoingFromInitial constraint of '<em>Pseudostate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate_validateOutgoingFromInitial(
			Pseudostate pseudostate, DiagnosticChain diagnostics, Map context) {
		return pseudostate.validateOutgoingFromInitial(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolConformance(
			ProtocolConformance protocolConformance,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			protocolConformance, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(protocolConformance,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(protocolConformance,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(protocolConformance,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(protocolConformance,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(protocolConformance,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationTemplateParameter(
			OperationTemplateParameter operationTemplateParameter,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(operationTemplateParameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateParameter_validateMustBeCompatible(
				operationTemplateParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeature(
			StructuralFeature structuralFeature, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(structuralFeature,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(structuralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(structuralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(structuralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(structuralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(structuralFeature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGt0(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateLowerGe0(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGeLower(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationNoSideEffects(
				structuralFeature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationConstant(
				structuralFeature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociation(Association association,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(association,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(association, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(association,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(association, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(association,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(association,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(association,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateSpecializedEndNumber(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateSpecializedEndTypes(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateBinaryAssociations(
				association, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateAssociationEnds(association,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSpecializedEndNumber constraint of '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociation_validateSpecializedEndNumber(
			Association association, DiagnosticChain diagnostics, Map context) {
		return association.validateSpecializedEndNumber(diagnostics, context);
	}

	/**
	 * Validates the validateSpecializedEndTypes constraint of '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociation_validateSpecializedEndTypes(
			Association association, DiagnosticChain diagnostics, Map context) {
		return association.validateSpecializedEndTypes(diagnostics, context);
	}

	/**
	 * Validates the validateBinaryAssociations constraint of '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociation_validateBinaryAssociations(
			Association association, DiagnosticChain diagnostics, Map context) {
		return association.validateBinaryAssociations(diagnostics, context);
	}

	/**
	 * Validates the validateAssociationEnds constraint of '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociation_validateAssociationEnds(
			Association association, DiagnosticChain diagnostics, Map context) {
		return association.validateAssociationEnds(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectableElementTemplateParameter(
			ConnectableElementTemplateParameter connectableElementTemplateParameter,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			connectableElementTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				connectableElementTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				connectableElementTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				connectableElementTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				connectableElementTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				connectableElementTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateParameter_validateMustBeCompatible(
				connectableElementTemplateParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollaborationUse(CollaborationUse collaborationUse,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(collaborationUse,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(collaborationUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(collaborationUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(collaborationUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(collaborationUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(collaborationUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				collaborationUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				collaborationUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				collaborationUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCollaborationUse_validateClientElements(
				collaborationUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCollaborationUse_validateEveryRole(
				collaborationUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCollaborationUse_validateConnectors(
				collaborationUse, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateClientElements constraint of '<em>Collaboration Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollaborationUse_validateClientElements(
			CollaborationUse collaborationUse, DiagnosticChain diagnostics,
			Map context) {
		return collaborationUse.validateClientElements(diagnostics, context);
	}

	/**
	 * Validates the validateEveryRole constraint of '<em>Collaboration Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollaborationUse_validateEveryRole(
			CollaborationUse collaborationUse, DiagnosticChain diagnostics,
			Map context) {
		return collaborationUse.validateEveryRole(diagnostics, context);
	}

	/**
	 * Validates the validateConnectors constraint of '<em>Collaboration Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollaborationUse_validateConnectors(
			CollaborationUse collaborationUse, DiagnosticChain diagnostics,
			Map context) {
		return collaborationUse.validateConnectors(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollaboration(Collaboration collaboration,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(collaboration,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(collaboration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(collaboration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(collaboration, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(collaboration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(collaboration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(collaboration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				collaboration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				collaboration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredClassifier(
			StructuredClassifier structuredClassifier,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(structuredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(structuredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(structuredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(structuredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(structuredClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				structuredClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				structuredClassifier, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMultiplicities constraint of '<em>Structured Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredClassifier_validateMultiplicities(
			StructuredClassifier structuredClassifier,
			DiagnosticChain diagnostics, Map context) {
		return structuredClassifier
			.validateMultiplicities(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector(Connector connector,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(connector,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(connector, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(connector,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(connector, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(connector,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(connector, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				connector, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(connector,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				connector, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				connector, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				connector, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnector_validateTypes(connector, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateConnector_validateCompatible(connector,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnector_validateRoles(connector, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateConnector_validateBetweenInterfacesPorts(
				connector, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnector_validateBetweenInterfacePortImplements(
				connector, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnector_validateBetweenInterfacePortSignature(
				connector, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnector_validateUnionSignatureCompatible(
				connector, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConnector_validateAssemblyConnector(connector,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypes constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector_validateTypes(Connector connector,
			DiagnosticChain diagnostics, Map context) {
		return connector.validateTypes(diagnostics, context);
	}

	/**
	 * Validates the validateCompatible constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector_validateCompatible(Connector connector,
			DiagnosticChain diagnostics, Map context) {
		return connector.validateCompatible(diagnostics, context);
	}

	/**
	 * Validates the validateRoles constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector_validateRoles(Connector connector,
			DiagnosticChain diagnostics, Map context) {
		return connector.validateRoles(diagnostics, context);
	}

	/**
	 * Validates the validateBetweenInterfacesPorts constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector_validateBetweenInterfacesPorts(
			Connector connector, DiagnosticChain diagnostics, Map context) {
		return connector.validateBetweenInterfacesPorts(diagnostics, context);
	}

	/**
	 * Validates the validateBetweenInterfacePortImplements constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector_validateBetweenInterfacePortImplements(
			Connector connector, DiagnosticChain diagnostics, Map context) {
		return connector.validateBetweenInterfacePortImplements(diagnostics,
			context);
	}

	/**
	 * Validates the validateBetweenInterfacePortSignature constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector_validateBetweenInterfacePortSignature(
			Connector connector, DiagnosticChain diagnostics, Map context) {
		return connector.validateBetweenInterfacePortSignature(diagnostics,
			context);
	}

	/**
	 * Validates the validateUnionSignatureCompatible constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector_validateUnionSignatureCompatible(
			Connector connector, DiagnosticChain diagnostics, Map context) {
		return connector.validateUnionSignatureCompatible(diagnostics, context);
	}

	/**
	 * Validates the validateAssemblyConnector constraint of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnector_validateAssemblyConnector(
			Connector connector, DiagnosticChain diagnostics, Map context) {
		return connector.validateAssemblyConnector(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedefinableTemplateSignature(
			RedefinableTemplateSignature redefinableTemplateSignature,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(redefinableTemplateSignature,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateSignature_validateOwnElements(
				redefinableTemplateSignature, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableTemplateSignature_validateInheritedParameters(
				redefinableTemplateSignature, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInheritedParameters constraint of '<em>Redefinable Template Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRedefinableTemplateSignature_validateInheritedParameters(
			RedefinableTemplateSignature redefinableTemplateSignature,
			DiagnosticChain diagnostics, Map context) {
		return redefinableTemplateSignature.validateInheritedParameters(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierTemplateParameter(
			ClassifierTemplateParameter classifierTemplateParameter,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(classifierTemplateParameter,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTemplateParameter_validateMustBeCompatible(
				classifierTemplateParameter, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifierTemplateParameter_validateHasConstrainingClassifier(
				classifierTemplateParameter, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateHasConstrainingClassifier constraint of '<em>Classifier Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassifierTemplateParameter_validateHasConstrainingClassifier(
			ClassifierTemplateParameter classifierTemplateParameter,
			DiagnosticChain diagnostics, Map context) {
		return classifierTemplateParameter.validateHasConstrainingClassifier(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterfaceRealization(
			InterfaceRealization interfaceRealization,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			interfaceRealization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interfaceRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interfaceRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interfaceRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(interfaceRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(interfaceRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				interfaceRealization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				interfaceRealization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				interfaceRealization, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEncapsulatedClassifier(
			EncapsulatedClassifier encapsulatedClassifier,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(encapsulatedClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(encapsulatedClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(encapsulatedClassifier,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				encapsulatedClassifier, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				encapsulatedClassifier, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtension(Extension extension,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(extension,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(extension, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(extension,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(extension, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(extension,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(extension, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(extension,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(extension,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateSpecializedEndNumber(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateSpecializedEndTypes(
				extension, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateBinaryAssociations(extension,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateAssociationEnds(extension,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExtension_validateNonOwnedEnd(extension,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExtension_validateIsBinary(extension,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNonOwnedEnd constraint of '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtension_validateNonOwnedEnd(Extension extension,
			DiagnosticChain diagnostics, Map context) {
		return extension.validateNonOwnedEnd(diagnostics, context);
	}

	/**
	 * Validates the validateIsBinary constraint of '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtension_validateIsBinary(Extension extension,
			DiagnosticChain diagnostics, Map context) {
		return extension.validateIsBinary(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtensionEnd(ExtensionEnd extensionEnd,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(extensionEnd,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(extensionEnd, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGt0(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateLowerGe0(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGeLower(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationNoSideEffects(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationConstant(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateMultiplicityOfComposite(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateSubsettingContextConforms(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateNavigablePropertyRedefinition(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateSubsettingRules(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateNavigableReadonly(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDerivedUnionIsDerived(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDerivedUnionIsReadOnly(
				extensionEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateDeploymentTarget(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProperty_validateBindingToAttribute(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExtensionEnd_validateMultiplicity(extensionEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExtensionEnd_validateAggregation(extensionEnd,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Extension End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtensionEnd_validateMultiplicity(
			ExtensionEnd extensionEnd, DiagnosticChain diagnostics, Map context) {
		return extensionEnd.validateMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the validateAggregation constraint of '<em>Extension End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExtensionEnd_validateAggregation(
			ExtensionEnd extensionEnd, DiagnosticChain diagnostics, Map context) {
		return extensionEnd.validateAggregation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImage(Image image, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(image, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringExpression(StringExpression stringExpression,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(stringExpression,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(stringExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(stringExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(stringExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(stringExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(stringExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				stringExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				stringExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				stringExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStringExpression_validateOperands(
				stringExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStringExpression_validateSubexpressions(
				stringExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOperands constraint of '<em>String Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringExpression_validateOperands(
			StringExpression stringExpression, DiagnosticChain diagnostics,
			Map context) {
		return stringExpression.validateOperands(diagnostics, context);
	}

	/**
	 * Validates the validateSubexpressions constraint of '<em>String Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringExpression_validateSubexpressions(
			StringExpression stringExpression, DiagnosticChain diagnostics,
			Map context) {
		return stringExpression.validateSubexpressions(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpression(Expression expression,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(expression,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(expression, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(expression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(expression, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(expression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(expression, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				expression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(expression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				expression, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralInteger(LiteralInteger literalInteger,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(literalInteger,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(literalInteger,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(literalInteger,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(literalInteger, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(literalInteger,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(literalInteger,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				literalInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				literalInteger, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				literalInteger, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralString(LiteralString literalString,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(literalString,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(literalString,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(literalString,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(literalString, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(literalString,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(literalString,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				literalString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				literalString, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				literalString, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralBoolean(LiteralBoolean literalBoolean,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(literalBoolean,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(literalBoolean,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(literalBoolean,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(literalBoolean, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(literalBoolean,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(literalBoolean,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				literalBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				literalBoolean, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				literalBoolean, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralNull(LiteralNull literalNull,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(literalNull,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(literalNull, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(literalNull,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(literalNull, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(literalNull,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(literalNull,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				literalNull, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				literalNull, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				literalNull, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSlot(Slot slot, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(slot, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(slot, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(slot, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(slot, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(slot, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(slot, diagnostics,
				context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSpecification(
			InstanceSpecification instanceSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			instanceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(instanceSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(instanceSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(instanceSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(instanceSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(instanceSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				instanceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				instanceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				instanceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInstanceSpecification_validateDefiningFeature(
				instanceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInstanceSpecification_validateStructuralFeature(
				instanceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInstanceSpecification_validateDeploymentTarget(
				instanceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInstanceSpecification_validateDeploymentArtifact(
				instanceSpecification, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDefiningFeature constraint of '<em>Instance Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSpecification_validateDefiningFeature(
			InstanceSpecification instanceSpecification,
			DiagnosticChain diagnostics, Map context) {
		return instanceSpecification.validateDefiningFeature(diagnostics,
			context);
	}

	/**
	 * Validates the validateStructuralFeature constraint of '<em>Instance Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSpecification_validateStructuralFeature(
			InstanceSpecification instanceSpecification,
			DiagnosticChain diagnostics, Map context) {
		return instanceSpecification.validateStructuralFeature(diagnostics,
			context);
	}

	/**
	 * Validates the validateDeploymentTarget constraint of '<em>Instance Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSpecification_validateDeploymentTarget(
			InstanceSpecification instanceSpecification,
			DiagnosticChain diagnostics, Map context) {
		return instanceSpecification.validateDeploymentTarget(diagnostics,
			context);
	}

	/**
	 * Validates the validateDeploymentArtifact constraint of '<em>Instance Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceSpecification_validateDeploymentArtifact(
			InstanceSpecification instanceSpecification,
			DiagnosticChain diagnostics, Map context) {
		return instanceSpecification.validateDeploymentArtifact(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumeration(Enumeration enumeration,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(enumeration,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(enumeration, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(enumeration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(enumeration, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(enumeration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(enumeration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				enumeration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				enumeration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				enumeration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				enumeration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				enumeration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				enumeration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				enumeration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				enumeration, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(enumeration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				enumeration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteral(
			EnumerationLiteral enumerationLiteral, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(enumerationLiteral,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(enumerationLiteral,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(enumerationLiteral,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(enumerationLiteral,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(enumerationLiteral,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(enumerationLiteral,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInstanceSpecification_validateDefiningFeature(
				enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInstanceSpecification_validateStructuralFeature(
				enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInstanceSpecification_validateDeploymentTarget(
				enumerationLiteral, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInstanceSpecification_validateDeploymentArtifact(
				enumerationLiteral, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveType(PrimitiveType primitiveType,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(primitiveType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(primitiveType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(primitiveType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(primitiveType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(primitiveType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(primitiveType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(primitiveType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				primitiveType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstanceValue(InstanceValue instanceValue,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(instanceValue,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(instanceValue,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(instanceValue,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(instanceValue, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(instanceValue,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(instanceValue,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				instanceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				instanceValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				instanceValue, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralUnlimitedNatural(
			LiteralUnlimitedNatural literalUnlimitedNatural,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			literalUnlimitedNatural, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(literalUnlimitedNatural,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				literalUnlimitedNatural, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(literalUnlimitedNatural,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				literalUnlimitedNatural, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(literalUnlimitedNatural,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				literalUnlimitedNatural, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				literalUnlimitedNatural, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				literalUnlimitedNatural, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueBehavior(OpaqueBehavior opaqueBehavior,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(opaqueBehavior,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(opaqueBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(opaqueBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(opaqueBehavior, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(opaqueBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(opaqueBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(opaqueBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(opaqueBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateParametersMatch(opaqueBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateFeatureOfContextClassifier(
				opaqueBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMustRealize(opaqueBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMostOneBehaviour(opaqueBehavior,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionBehavior(FunctionBehavior functionBehavior,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(functionBehavior,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(functionBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(functionBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(functionBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(functionBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(functionBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(functionBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateParametersMatch(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateFeatureOfContextClassifier(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMustRealize(functionBehavior,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMostOneBehaviour(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFunctionBehavior_validateOneOutputParameter(
				functionBehavior, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFunctionBehavior_validateTypesOfParameters(
				functionBehavior, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOneOutputParameter constraint of '<em>Function Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionBehavior_validateOneOutputParameter(
			FunctionBehavior functionBehavior, DiagnosticChain diagnostics,
			Map context) {
		return functionBehavior
			.validateOneOutputParameter(diagnostics, context);
	}

	/**
	 * Validates the validateTypesOfParameters constraint of '<em>Function Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionBehavior_validateTypesOfParameters(
			FunctionBehavior functionBehavior, DiagnosticChain diagnostics,
			Map context) {
		return functionBehavior.validateTypesOfParameters(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor(Actor actor, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(actor, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(actor, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(actor, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(actor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(actor, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(actor, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(actor,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(actor,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				actor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(actor,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				actor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				actor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				actor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				actor, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(actor,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(actor,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(actor,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActor_validateAssociations(actor, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateActor_validateMustHaveName(actor, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validateAssociations constraint of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor_validateAssociations(Actor actor,
			DiagnosticChain diagnostics, Map context) {
		return actor.validateAssociations(diagnostics, context);
	}

	/**
	 * Validates the validateMustHaveName constraint of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor_validateMustHaveName(Actor actor,
			DiagnosticChain diagnostics, Map context) {
		return actor.validateMustHaveName(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUsage(Usage usage, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(usage, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(usage, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(usage, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(usage, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(usage, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(usage, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(usage,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(usage,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				usage, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage(Message message,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(message,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(message, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(message, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(message, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(message, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(message, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(message,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(message,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				message, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMessage_validateSendingReceivingMessageEvent(
				message, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMessage_validateSignatureReferTo(message,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMessage_validateSignatureIsOperation(message,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMessage_validateSignatureIsSignal(message,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMessage_validateArguments(message, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateMessage_validateCannotCrossBoundaries(message,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMessage_validateOccurrenceSpecifications(message,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSendingReceivingMessageEvent constraint of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage_validateSendingReceivingMessageEvent(
			Message message, DiagnosticChain diagnostics, Map context) {
		return message.validateSendingReceivingMessageEvent(diagnostics,
			context);
	}

	/**
	 * Validates the validateSignatureReferTo constraint of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage_validateSignatureReferTo(Message message,
			DiagnosticChain diagnostics, Map context) {
		return message.validateSignatureReferTo(diagnostics, context);
	}

	/**
	 * Validates the validateSignatureIsOperation constraint of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage_validateSignatureIsOperation(
			Message message, DiagnosticChain diagnostics, Map context) {
		return message.validateSignatureIsOperation(diagnostics, context);
	}

	/**
	 * Validates the validateSignatureIsSignal constraint of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage_validateSignatureIsSignal(Message message,
			DiagnosticChain diagnostics, Map context) {
		return message.validateSignatureIsSignal(diagnostics, context);
	}

	/**
	 * Validates the validateArguments constraint of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage_validateArguments(Message message,
			DiagnosticChain diagnostics, Map context) {
		return message.validateArguments(diagnostics, context);
	}

	/**
	 * Validates the validateCannotCrossBoundaries constraint of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage_validateCannotCrossBoundaries(
			Message message, DiagnosticChain diagnostics, Map context) {
		return message.validateCannotCrossBoundaries(diagnostics, context);
	}

	/**
	 * Validates the validateOccurrenceSpecifications constraint of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessage_validateOccurrenceSpecifications(
			Message message, DiagnosticChain diagnostics, Map context) {
		return message.validateOccurrenceSpecifications(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageEnd(MessageEnd messageEnd,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(messageEnd,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(messageEnd, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(messageEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(messageEnd, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(messageEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(messageEnd, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				messageEnd, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(messageEnd,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				messageEnd, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteraction(Interaction interaction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(interaction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interaction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interaction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interaction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(interaction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(interaction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(interaction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(interaction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateParametersMatch(interaction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateFeatureOfContextClassifier(
				interaction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMustRealize(interaction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMostOneBehaviour(interaction,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionFragment(
			InteractionFragment interactionFragment,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			interactionFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interactionFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interactionFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interactionFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(interactionFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(interactionFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				interactionFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				interactionFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				interactionFragment, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLifeline(Lifeline lifeline,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(lifeline,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(lifeline, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(lifeline, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(lifeline, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(lifeline, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(lifeline, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(lifeline,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(lifeline,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				lifeline, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLifeline_validateInteractionUsesShareLifeline(
				lifeline, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLifeline_validateSelectorSpecified(lifeline,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLifeline_validateSameClassifier(lifeline,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInteractionUsesShareLifeline constraint of '<em>Lifeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLifeline_validateInteractionUsesShareLifeline(
			Lifeline lifeline, DiagnosticChain diagnostics, Map context) {
		return lifeline.validateInteractionUsesShareLifeline(diagnostics,
			context);
	}

	/**
	 * Validates the validateSelectorSpecified constraint of '<em>Lifeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLifeline_validateSelectorSpecified(
			Lifeline lifeline, DiagnosticChain diagnostics, Map context) {
		return lifeline.validateSelectorSpecified(diagnostics, context);
	}

	/**
	 * Validates the validateSameClassifier constraint of '<em>Lifeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLifeline_validateSameClassifier(Lifeline lifeline,
			DiagnosticChain diagnostics, Map context) {
		return lifeline.validateSameClassifier(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartDecomposition(
			PartDecomposition partDecomposition, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(partDecomposition,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(partDecomposition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(partDecomposition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(partDecomposition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(partDecomposition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(partDecomposition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionUse_validateGatesMatch(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionUse_validateAllLifelines(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionUse_validateArgumentsCorrespondToParameters(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionUse_validateArgumentsAreConstants(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePartDecomposition_validatePartsOfInternalStructures(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePartDecomposition_validateAssume(
				partDecomposition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePartDecomposition_validateCommutativityOfDecomposition(
				partDecomposition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validatePartsOfInternalStructures constraint of '<em>Part Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartDecomposition_validatePartsOfInternalStructures(
			PartDecomposition partDecomposition, DiagnosticChain diagnostics,
			Map context) {
		return partDecomposition.validatePartsOfInternalStructures(diagnostics,
			context);
	}

	/**
	 * Validates the validateAssume constraint of '<em>Part Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartDecomposition_validateAssume(
			PartDecomposition partDecomposition, DiagnosticChain diagnostics,
			Map context) {
		return partDecomposition.validateAssume(diagnostics, context);
	}

	/**
	 * Validates the validateCommutativityOfDecomposition constraint of '<em>Part Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePartDecomposition_validateCommutativityOfDecomposition(
			PartDecomposition partDecomposition, DiagnosticChain diagnostics,
			Map context) {
		return partDecomposition.validateCommutativityOfDecomposition(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionUse(InteractionUse interactionUse,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(interactionUse,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interactionUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interactionUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interactionUse, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(interactionUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(interactionUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				interactionUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				interactionUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				interactionUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionUse_validateGatesMatch(interactionUse,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionUse_validateAllLifelines(
				interactionUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionUse_validateArgumentsCorrespondToParameters(
				interactionUse, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionUse_validateArgumentsAreConstants(
				interactionUse, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateGatesMatch constraint of '<em>Interaction Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionUse_validateGatesMatch(
			InteractionUse interactionUse, DiagnosticChain diagnostics,
			Map context) {
		return interactionUse.validateGatesMatch(diagnostics, context);
	}

	/**
	 * Validates the validateAllLifelines constraint of '<em>Interaction Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionUse_validateAllLifelines(
			InteractionUse interactionUse, DiagnosticChain diagnostics,
			Map context) {
		return interactionUse.validateAllLifelines(diagnostics, context);
	}

	/**
	 * Validates the validateArgumentsCorrespondToParameters constraint of '<em>Interaction Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionUse_validateArgumentsCorrespondToParameters(
			InteractionUse interactionUse, DiagnosticChain diagnostics,
			Map context) {
		return interactionUse.validateArgumentsCorrespondToParameters(
			diagnostics, context);
	}

	/**
	 * Validates the validateArgumentsAreConstants constraint of '<em>Interaction Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionUse_validateArgumentsAreConstants(
			InteractionUse interactionUse, DiagnosticChain diagnostics,
			Map context) {
		return interactionUse.validateArgumentsAreConstants(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGate(Gate gate, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(gate, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(gate, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(gate, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(gate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(gate, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(gate, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(gate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(gate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				gate, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateGate_validateMessagesActualGate(gate,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateGate_validateMessagesCombinedFragment(gate,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMessagesActualGate constraint of '<em>Gate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGate_validateMessagesActualGate(Gate gate,
			DiagnosticChain diagnostics, Map context) {
		return gate.validateMessagesActualGate(diagnostics, context);
	}

	/**
	 * Validates the validateMessagesCombinedFragment constraint of '<em>Gate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGate_validateMessagesCombinedFragment(Gate gate,
			DiagnosticChain diagnostics, Map context) {
		return gate.validateMessagesCombinedFragment(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAction(Action action, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(action,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(action, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(action, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(action, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(action, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(action, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(action,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(action,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				action, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				action, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				action, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(action, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(action,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExecutableNode(ExecutableNode executableNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(executableNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(executableNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(executableNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(executableNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(executableNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(executableNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				executableNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				executableNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				executableNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				executableNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				executableNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(executableNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				executableNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityNode(ActivityNode activityNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(activityNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(activityNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(activityNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(activityNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(activityNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(activityNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				activityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				activityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				activityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				activityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				activityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(activityNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				activityNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOwned constraint of '<em>Activity Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityNode_validateOwned(
			ActivityNode activityNode, DiagnosticChain diagnostics, Map context) {
		return activityNode.validateOwned(diagnostics, context);
	}

	/**
	 * Validates the validateOwnedStructuredNode constraint of '<em>Activity Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityNode_validateOwnedStructuredNode(
			ActivityNode activityNode, DiagnosticChain diagnostics, Map context) {
		return activityNode.validateOwnedStructuredNode(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityEdge(ActivityEdge activityEdge,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(activityEdge,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(activityEdge,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(activityEdge,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(activityEdge, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(activityEdge,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(activityEdge,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				activityEdge, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				activityEdge, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				activityEdge, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				activityEdge, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				activityEdge, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateSourceAndTarget(
				activityEdge, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateOwned(activityEdge,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateStructuredNode(activityEdge,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSourceAndTarget constraint of '<em>Activity Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityEdge_validateSourceAndTarget(
			ActivityEdge activityEdge, DiagnosticChain diagnostics, Map context) {
		return activityEdge.validateSourceAndTarget(diagnostics, context);
	}

	/**
	 * Validates the validateOwned constraint of '<em>Activity Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityEdge_validateOwned(
			ActivityEdge activityEdge, DiagnosticChain diagnostics, Map context) {
		return activityEdge.validateOwned(diagnostics, context);
	}

	/**
	 * Validates the validateStructuredNode constraint of '<em>Activity Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityEdge_validateStructuredNode(
			ActivityEdge activityEdge, DiagnosticChain diagnostics, Map context) {
		return activityEdge.validateStructuredNode(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivity(Activity activity,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(activity,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(activity, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(activity, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(activity, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(activity, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(activity, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(activity,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(activity,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(activity,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(activity, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateParametersMatch(activity,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateFeatureOfContextClassifier(
				activity, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMustRealize(activity,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavior_validateMostOneBehaviour(activity,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivity_validateNoSupergroups(activity,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivity_validateActivityParameterNode(activity,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivity_validateAutonomous(activity,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoSupergroups constraint of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivity_validateNoSupergroups(Activity activity,
			DiagnosticChain diagnostics, Map context) {
		return activity.validateNoSupergroups(diagnostics, context);
	}

	/**
	 * Validates the validateActivityParameterNode constraint of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivity_validateActivityParameterNode(
			Activity activity, DiagnosticChain diagnostics, Map context) {
		return activity.validateActivityParameterNode(diagnostics, context);
	}

	/**
	 * Validates the validateAutonomous constraint of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivity_validateAutonomous(Activity activity,
			DiagnosticChain diagnostics, Map context) {
		return activity.validateAutonomous(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityPartition(
			ActivityPartition activityPartition, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(activityPartition,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(activityPartition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(activityPartition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(activityPartition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(activityPartition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(activityPartition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNodesAndEdges(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNotContained(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateGroupOwned(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityPartition_validateDimensionNotContained(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityPartition_validateNodeOrEdge(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityPartition_validateRepresentsPart(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityPartition_validateRepresentsClassifier(
				activityPartition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityPartition_validateRepresentsPartAndIsContained(
				activityPartition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDimensionNotContained constraint of '<em>Activity Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityPartition_validateDimensionNotContained(
			ActivityPartition activityPartition, DiagnosticChain diagnostics,
			Map context) {
		return activityPartition.validateDimensionNotContained(diagnostics,
			context);
	}

	/**
	 * Validates the validateNodeOrEdge constraint of '<em>Activity Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityPartition_validateNodeOrEdge(
			ActivityPartition activityPartition, DiagnosticChain diagnostics,
			Map context) {
		return activityPartition.validateNodeOrEdge(diagnostics, context);
	}

	/**
	 * Validates the validateRepresentsPart constraint of '<em>Activity Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityPartition_validateRepresentsPart(
			ActivityPartition activityPartition, DiagnosticChain diagnostics,
			Map context) {
		return activityPartition.validateRepresentsPart(diagnostics, context);
	}

	/**
	 * Validates the validateRepresentsClassifier constraint of '<em>Activity Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityPartition_validateRepresentsClassifier(
			ActivityPartition activityPartition, DiagnosticChain diagnostics,
			Map context) {
		return activityPartition.validateRepresentsClassifier(diagnostics,
			context);
	}

	/**
	 * Validates the validateRepresentsPartAndIsContained constraint of '<em>Activity Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityPartition_validateRepresentsPartAndIsContained(
			ActivityPartition activityPartition, DiagnosticChain diagnostics,
			Map context) {
		return activityPartition.validateRepresentsPartAndIsContained(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityGroup(ActivityGroup activityGroup,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(activityGroup,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(activityGroup,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(activityGroup,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(activityGroup, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(activityGroup,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(activityGroup,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNodesAndEdges(
				activityGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNotContained(activityGroup,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateGroupOwned(activityGroup,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNodesAndEdges constraint of '<em>Activity Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityGroup_validateNodesAndEdges(
			ActivityGroup activityGroup, DiagnosticChain diagnostics,
			Map context) {
		return activityGroup.validateNodesAndEdges(diagnostics, context);
	}

	/**
	 * Validates the validateNotContained constraint of '<em>Activity Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityGroup_validateNotContained(
			ActivityGroup activityGroup, DiagnosticChain diagnostics,
			Map context) {
		return activityGroup.validateNotContained(diagnostics, context);
	}

	/**
	 * Validates the validateGroupOwned constraint of '<em>Activity Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityGroup_validateGroupOwned(
			ActivityGroup activityGroup, DiagnosticChain diagnostics,
			Map context) {
		return activityGroup.validateGroupOwned(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredActivityNode(
			StructuredActivityNode structuredActivityNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(structuredActivityNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(structuredActivityNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(structuredActivityNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNodesAndEdges(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNotContained(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateGroupOwned(
				structuredActivityNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredActivityNode_validateEdges(
				structuredActivityNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateEdges constraint of '<em>Structured Activity Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuredActivityNode_validateEdges(
			StructuredActivityNode structuredActivityNode,
			DiagnosticChain diagnostics, Map context) {
		return structuredActivityNode.validateEdges(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(variable,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(variable,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(variable,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				variable, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGt0(variable,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateLowerGe0(variable,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateUpperGeLower(
				variable, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationNoSideEffects(
				variable, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMultiplicityElement_validateValueSpecificationConstant(
				variable, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateVariable_validateOwned(variable, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validateOwned constraint of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable_validateOwned(Variable variable,
			DiagnosticChain diagnostics, Map context) {
		return variable.validateOwned(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterruptibleActivityRegion(
			InterruptibleActivityRegion interruptibleActivityRegion,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			interruptibleActivityRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				interruptibleActivityRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				interruptibleActivityRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interruptibleActivityRegion,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				interruptibleActivityRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				interruptibleActivityRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNodesAndEdges(
				interruptibleActivityRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNotContained(
				interruptibleActivityRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateGroupOwned(
				interruptibleActivityRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInterruptibleActivityRegion_validateInterruptingEdges(
				interruptibleActivityRegion, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInterruptingEdges constraint of '<em>Interruptible Activity Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterruptibleActivityRegion_validateInterruptingEdges(
			InterruptibleActivityRegion interruptibleActivityRegion,
			DiagnosticChain diagnostics, Map context) {
		return interruptibleActivityRegion.validateInterruptingEdges(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExceptionHandler(ExceptionHandler exceptionHandler,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(exceptionHandler,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(exceptionHandler,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(exceptionHandler,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(exceptionHandler,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(exceptionHandler,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(exceptionHandler,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExceptionHandler_validateExceptionBody(
				exceptionHandler, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExceptionHandler_validateResultPins(
				exceptionHandler, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExceptionHandler_validateOneInput(
				exceptionHandler, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExceptionHandler_validateEdgeSourceTarget(
				exceptionHandler, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateExceptionBody constraint of '<em>Exception Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExceptionHandler_validateExceptionBody(
			ExceptionHandler exceptionHandler, DiagnosticChain diagnostics,
			Map context) {
		return exceptionHandler.validateExceptionBody(diagnostics, context);
	}

	/**
	 * Validates the validateResultPins constraint of '<em>Exception Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExceptionHandler_validateResultPins(
			ExceptionHandler exceptionHandler, DiagnosticChain diagnostics,
			Map context) {
		return exceptionHandler.validateResultPins(diagnostics, context);
	}

	/**
	 * Validates the validateOneInput constraint of '<em>Exception Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExceptionHandler_validateOneInput(
			ExceptionHandler exceptionHandler, DiagnosticChain diagnostics,
			Map context) {
		return exceptionHandler.validateOneInput(diagnostics, context);
	}

	/**
	 * Validates the validateEdgeSourceTarget constraint of '<em>Exception Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExceptionHandler_validateEdgeSourceTarget(
			ExceptionHandler exceptionHandler, DiagnosticChain diagnostics,
			Map context) {
		return exceptionHandler.validateEdgeSourceTarget(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectNode(ObjectNode objectNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(objectNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(objectNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(objectNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(objectNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(objectNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(objectNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				objectNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(objectNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				objectNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				objectNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				objectNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(objectNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				objectNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(objectNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(objectNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(objectNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(
				objectNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateObjectFlowEdges constraint of '<em>Object Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectNode_validateObjectFlowEdges(
			ObjectNode objectNode, DiagnosticChain diagnostics, Map context) {
		return objectNode.validateObjectFlowEdges(diagnostics, context);
	}

	/**
	 * Validates the validateNotUnique constraint of '<em>Object Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectNode_validateNotUnique(ObjectNode objectNode,
			DiagnosticChain diagnostics, Map context) {
		return objectNode.validateNotUnique(diagnostics, context);
	}

	/**
	 * Validates the validateSelectionBehavior constraint of '<em>Object Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectNode_validateSelectionBehavior(
			ObjectNode objectNode, DiagnosticChain diagnostics, Map context) {
		return objectNode.validateSelectionBehavior(diagnostics, context);
	}

	/**
	 * Validates the validateInputOutputParameter constraint of '<em>Object Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectNode_validateInputOutputParameter(
			ObjectNode objectNode, DiagnosticChain diagnostics, Map context) {
		return objectNode.validateInputOutputParameter(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputPin(OutputPin outputPin,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(outputPin,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(outputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(outputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(outputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(outputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(outputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				outputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(outputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				outputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				outputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				outputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(outputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				outputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(outputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(outputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(outputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(
				outputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePin_validateControlPins(outputPin, diagnostics,
				context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePin(Pin pin, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(pin, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(pin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(pin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(pin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(pin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(pin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(pin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(pin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				pin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				pin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				pin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(pin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(pin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(pin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(pin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(pin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(pin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePin_validateControlPins(pin, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateControlPins constraint of '<em>Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePin_validateControlPins(Pin pin,
			DiagnosticChain diagnostics, Map context) {
		return pin.validateControlPins(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputPin(InputPin inputPin,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(inputPin,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(inputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(inputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(inputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(inputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(inputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(inputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(inputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				inputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				inputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				inputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(inputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				inputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(inputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(inputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(inputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(inputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePin_validateControlPins(inputPin, diagnostics,
				context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralOrdering(GeneralOrdering generalOrdering,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(generalOrdering,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(generalOrdering,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(generalOrdering,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(generalOrdering, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(generalOrdering,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(generalOrdering,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				generalOrdering, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				generalOrdering, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				generalOrdering, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOccurrenceSpecification(
			OccurrenceSpecification occurrenceSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			occurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(occurrenceSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				occurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(occurrenceSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				occurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(occurrenceSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				occurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				occurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				occurrenceSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionOperand(
			InteractionOperand interactionOperand, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(interactionOperand,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interactionOperand,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interactionOperand,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interactionOperand,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(interactionOperand,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(interactionOperand,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				interactionOperand, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				interactionOperand, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				interactionOperand, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				interactionOperand, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionOperand_validateGuardDirectlyPrior(
				interactionOperand, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionOperand_validateGuardContainReferences(
				interactionOperand, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateGuardDirectlyPrior constraint of '<em>Interaction Operand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionOperand_validateGuardDirectlyPrior(
			InteractionOperand interactionOperand, DiagnosticChain diagnostics,
			Map context) {
		return interactionOperand.validateGuardDirectlyPrior(diagnostics,
			context);
	}

	/**
	 * Validates the validateGuardContainReferences constraint of '<em>Interaction Operand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionOperand_validateGuardContainReferences(
			InteractionOperand interactionOperand, DiagnosticChain diagnostics,
			Map context) {
		return interactionOperand.validateGuardContainReferences(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionConstraint(
			InteractionConstraint interactionConstraint,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interactionConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interactionConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interactionConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(interactionConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(interactionConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotApplyToSelf(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateValueSpecificationBoolean(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateBooleanValue(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNoSideEffects(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotAppliedToSelf(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionConstraint_validateDynamicVariables(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionConstraint_validateGlobalData(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionConstraint_validateMinintMaxint(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionConstraint_validateMinintNonNegative(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionConstraint_validateMaxintPositive(
				interactionConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInteractionConstraint_validateMaxintGreaterEqualMinint(
				interactionConstraint, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDynamicVariables constraint of '<em>Interaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionConstraint_validateDynamicVariables(
			InteractionConstraint interactionConstraint,
			DiagnosticChain diagnostics, Map context) {
		return interactionConstraint.validateDynamicVariables(diagnostics,
			context);
	}

	/**
	 * Validates the validateGlobalData constraint of '<em>Interaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionConstraint_validateGlobalData(
			InteractionConstraint interactionConstraint,
			DiagnosticChain diagnostics, Map context) {
		return interactionConstraint.validateGlobalData(diagnostics, context);
	}

	/**
	 * Validates the validateMinintMaxint constraint of '<em>Interaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionConstraint_validateMinintMaxint(
			InteractionConstraint interactionConstraint,
			DiagnosticChain diagnostics, Map context) {
		return interactionConstraint.validateMinintMaxint(diagnostics, context);
	}

	/**
	 * Validates the validateMinintNonNegative constraint of '<em>Interaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionConstraint_validateMinintNonNegative(
			InteractionConstraint interactionConstraint,
			DiagnosticChain diagnostics, Map context) {
		return interactionConstraint.validateMinintNonNegative(diagnostics,
			context);
	}

	/**
	 * Validates the validateMaxintPositive constraint of '<em>Interaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionConstraint_validateMaxintPositive(
			InteractionConstraint interactionConstraint,
			DiagnosticChain diagnostics, Map context) {
		return interactionConstraint.validateMaxintPositive(diagnostics,
			context);
	}

	/**
	 * Validates the validateMaxintGreaterEqualMinint constraint of '<em>Interaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionConstraint_validateMaxintGreaterEqualMinint(
			InteractionConstraint interactionConstraint,
			DiagnosticChain diagnostics, Map context) {
		return interactionConstraint.validateMaxintGreaterEqualMinint(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExecutionSpecification(
			ExecutionSpecification executionSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			executionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(executionSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				executionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(executionSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				executionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(executionSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				executionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				executionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				executionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExecutionSpecification_validateSameLifeline(
				executionSpecification, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSameLifeline constraint of '<em>Execution Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExecutionSpecification_validateSameLifeline(
			ExecutionSpecification executionSpecification,
			DiagnosticChain diagnostics, Map context) {
		return executionSpecification
			.validateSameLifeline(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExecutionOccurrenceSpecification(
			ExecutionOccurrenceSpecification executionOccurrenceSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			executionOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				executionOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				executionOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				executionOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				executionOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				executionOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				executionOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				executionOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				executionOccurrenceSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExecutionEvent(ExecutionEvent executionEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(executionEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(executionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(executionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(executionEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(executionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(executionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				executionEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				executionEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				executionEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateInvariant(StateInvariant stateInvariant,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(stateInvariant,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(stateInvariant,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(stateInvariant,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(stateInvariant, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(stateInvariant,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(stateInvariant,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				stateInvariant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				stateInvariant, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				stateInvariant, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionExecutionSpecification(
			ActionExecutionSpecification actionExecutionSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(actionExecutionSpecification,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExecutionSpecification_validateSameLifeline(
				actionExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActionExecutionSpecification_validateActionReferenced(
				actionExecutionSpecification, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateActionReferenced constraint of '<em>Action Execution Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionExecutionSpecification_validateActionReferenced(
			ActionExecutionSpecification actionExecutionSpecification,
			DiagnosticChain diagnostics, Map context) {
		return actionExecutionSpecification.validateActionReferenced(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorExecutionSpecification(
			BehaviorExecutionSpecification behaviorExecutionSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				behaviorExecutionSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExecutionSpecification_validateSameLifeline(
				behaviorExecutionSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreationEvent(CreationEvent creationEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(creationEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(creationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(creationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(creationEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(creationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(creationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				creationEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				creationEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				creationEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreationEvent_validateNoOccurrenceAbove(
				creationEvent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoOccurrenceAbove constraint of '<em>Creation Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreationEvent_validateNoOccurrenceAbove(
			CreationEvent creationEvent, DiagnosticChain diagnostics,
			Map context) {
		return creationEvent.validateNoOccurrenceAbove(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDestructionEvent(DestructionEvent destructionEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(destructionEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(destructionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(destructionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(destructionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(destructionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(destructionEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				destructionEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				destructionEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				destructionEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDestructionEvent_validateNoOccurrenceSpecificationsBelow(
				destructionEvent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoOccurrenceSpecificationsBelow constraint of '<em>Destruction Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDestructionEvent_validateNoOccurrenceSpecificationsBelow(
			DestructionEvent destructionEvent, DiagnosticChain diagnostics,
			Map context) {
		return destructionEvent.validateNoOccurrenceSpecificationsBelow(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendOperationEvent(
			SendOperationEvent sendOperationEvent, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(sendOperationEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(sendOperationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(sendOperationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(sendOperationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(sendOperationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(sendOperationEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				sendOperationEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				sendOperationEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				sendOperationEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageEvent(MessageEvent messageEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(messageEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(messageEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(messageEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(messageEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(messageEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(messageEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				messageEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				messageEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				messageEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendSignalEvent(SendSignalEvent sendSignalEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(sendSignalEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(sendSignalEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(sendSignalEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(sendSignalEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(sendSignalEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(sendSignalEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				sendSignalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				sendSignalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				sendSignalEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageOccurrenceSpecification(
			MessageOccurrenceSpecification messageOccurrenceSpecification,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			messageOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				messageOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				messageOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				messageOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				messageOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				messageOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				messageOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				messageOccurrenceSpecification, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				messageOccurrenceSpecification, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCombinedFragment(CombinedFragment combinedFragment,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(combinedFragment,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(combinedFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(combinedFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(combinedFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(combinedFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(combinedFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				combinedFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				combinedFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				combinedFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCombinedFragment_validateOptLoopBreakNeg(
				combinedFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCombinedFragment_validateMinintAndMaxint(
				combinedFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCombinedFragment_validateBreak(combinedFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCombinedFragment_validateConsiderAndIgnore(
				combinedFragment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOptLoopBreakNeg constraint of '<em>Combined Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCombinedFragment_validateOptLoopBreakNeg(
			CombinedFragment combinedFragment, DiagnosticChain diagnostics,
			Map context) {
		return combinedFragment.validateOptLoopBreakNeg(diagnostics, context);
	}

	/**
	 * Validates the validateMinintAndMaxint constraint of '<em>Combined Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCombinedFragment_validateMinintAndMaxint(
			CombinedFragment combinedFragment, DiagnosticChain diagnostics,
			Map context) {
		return combinedFragment.validateMinintAndMaxint(diagnostics, context);
	}

	/**
	 * Validates the validateBreak constraint of '<em>Combined Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCombinedFragment_validateBreak(
			CombinedFragment combinedFragment, DiagnosticChain diagnostics,
			Map context) {
		return combinedFragment.validateBreak(diagnostics, context);
	}

	/**
	 * Validates the validateConsiderAndIgnore constraint of '<em>Combined Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCombinedFragment_validateConsiderAndIgnore(
			CombinedFragment combinedFragment, DiagnosticChain diagnostics,
			Map context) {
		return combinedFragment.validateConsiderAndIgnore(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinuation(Continuation continuation,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(continuation,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(continuation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(continuation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(continuation, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(continuation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(continuation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				continuation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				continuation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				continuation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateContinuation_validateSameName(continuation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateContinuation_validateGlobal(continuation,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateContinuation_validateFirstOrLastInteractionFragment(
				continuation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSameName constraint of '<em>Continuation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinuation_validateSameName(
			Continuation continuation, DiagnosticChain diagnostics, Map context) {
		return continuation.validateSameName(diagnostics, context);
	}

	/**
	 * Validates the validateGlobal constraint of '<em>Continuation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinuation_validateGlobal(
			Continuation continuation, DiagnosticChain diagnostics, Map context) {
		return continuation.validateGlobal(diagnostics, context);
	}

	/**
	 * Validates the validateFirstOrLastInteractionFragment constraint of '<em>Continuation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinuation_validateFirstOrLastInteractionFragment(
			Continuation continuation, DiagnosticChain diagnostics, Map context) {
		return continuation.validateFirstOrLastInteractionFragment(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConsiderIgnoreFragment(
			ConsiderIgnoreFragment considerIgnoreFragment,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(considerIgnoreFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(considerIgnoreFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(considerIgnoreFragment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCombinedFragment_validateOptLoopBreakNeg(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCombinedFragment_validateMinintAndMaxint(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCombinedFragment_validateBreak(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCombinedFragment_validateConsiderAndIgnore(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConsiderIgnoreFragment_validateConsiderOrIgnore(
				considerIgnoreFragment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConsiderIgnoreFragment_validateType(
				considerIgnoreFragment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateConsiderOrIgnore constraint of '<em>Consider Ignore Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConsiderIgnoreFragment_validateConsiderOrIgnore(
			ConsiderIgnoreFragment considerIgnoreFragment,
			DiagnosticChain diagnostics, Map context) {
		return considerIgnoreFragment.validateConsiderOrIgnore(diagnostics,
			context);
	}

	/**
	 * Validates the validateType constraint of '<em>Consider Ignore Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConsiderIgnoreFragment_validateType(
			ConsiderIgnoreFragment considerIgnoreFragment,
			DiagnosticChain diagnostics, Map context) {
		return considerIgnoreFragment.validateType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallEvent(CallEvent callEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(callEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(callEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(callEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(callEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(callEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(callEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				callEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(callEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				callEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChangeEvent(ChangeEvent changeEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(changeEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(changeEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(changeEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(changeEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(changeEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(changeEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				changeEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				changeEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				changeEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignalEvent(SignalEvent signalEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(signalEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(signalEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(signalEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(signalEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(signalEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(signalEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				signalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				signalEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				signalEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyReceiveEvent(AnyReceiveEvent anyReceiveEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(anyReceiveEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(anyReceiveEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(anyReceiveEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(anyReceiveEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(anyReceiveEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(anyReceiveEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				anyReceiveEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				anyReceiveEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				anyReceiveEvent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateObjectAction(
			CreateObjectAction createObjectAction, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(createObjectAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(createObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(createObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(createObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(createObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(createObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(createObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateObjectAction_validateClassifierNotAbstract(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateObjectAction_validateClassifierNotAssociationClass(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateObjectAction_validateSameType(
				createObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateObjectAction_validateMultiplicity(
				createObjectAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateClassifierNotAbstract constraint of '<em>Create Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateObjectAction_validateClassifierNotAbstract(
			CreateObjectAction createObjectAction, DiagnosticChain diagnostics,
			Map context) {
		return createObjectAction.validateClassifierNotAbstract(diagnostics,
			context);
	}

	/**
	 * Validates the validateClassifierNotAssociationClass constraint of '<em>Create Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateObjectAction_validateClassifierNotAssociationClass(
			CreateObjectAction createObjectAction, DiagnosticChain diagnostics,
			Map context) {
		return createObjectAction.validateClassifierNotAssociationClass(
			diagnostics, context);
	}

	/**
	 * Validates the validateSameType constraint of '<em>Create Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateObjectAction_validateSameType(
			CreateObjectAction createObjectAction, DiagnosticChain diagnostics,
			Map context) {
		return createObjectAction.validateSameType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Create Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateObjectAction_validateMultiplicity(
			CreateObjectAction createObjectAction, DiagnosticChain diagnostics,
			Map context) {
		return createObjectAction.validateMultiplicity(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDestroyObjectAction(
			DestroyObjectAction destroyObjectAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			destroyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(destroyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(destroyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(destroyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(destroyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(destroyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				destroyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				destroyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				destroyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				destroyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				destroyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(destroyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				destroyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDestroyObjectAction_validateMultiplicity(
				destroyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDestroyObjectAction_validateNoType(
				destroyObjectAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Destroy Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDestroyObjectAction_validateMultiplicity(
			DestroyObjectAction destroyObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return destroyObjectAction.validateMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the validateNoType constraint of '<em>Destroy Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDestroyObjectAction_validateNoType(
			DestroyObjectAction destroyObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return destroyObjectAction.validateNoType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestIdentityAction(
			TestIdentityAction testIdentityAction, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(testIdentityAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(testIdentityAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(testIdentityAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(testIdentityAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(testIdentityAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(testIdentityAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				testIdentityAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				testIdentityAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				testIdentityAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				testIdentityAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				testIdentityAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(testIdentityAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				testIdentityAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTestIdentityAction_validateNoType(
				testIdentityAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTestIdentityAction_validateMultiplicity(
				testIdentityAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTestIdentityAction_validateResultIsBoolean(
				testIdentityAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoType constraint of '<em>Test Identity Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestIdentityAction_validateNoType(
			TestIdentityAction testIdentityAction, DiagnosticChain diagnostics,
			Map context) {
		return testIdentityAction.validateNoType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Test Identity Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestIdentityAction_validateMultiplicity(
			TestIdentityAction testIdentityAction, DiagnosticChain diagnostics,
			Map context) {
		return testIdentityAction.validateMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the validateResultIsBoolean constraint of '<em>Test Identity Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestIdentityAction_validateResultIsBoolean(
			TestIdentityAction testIdentityAction, DiagnosticChain diagnostics,
			Map context) {
		return testIdentityAction.validateResultIsBoolean(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadSelfAction(ReadSelfAction readSelfAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(readSelfAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(readSelfAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(readSelfAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(readSelfAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(readSelfAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(readSelfAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				readSelfAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				readSelfAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				readSelfAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				readSelfAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				readSelfAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(readSelfAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				readSelfAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadSelfAction_validateContained(readSelfAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadSelfAction_validateNotStatic(readSelfAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadSelfAction_validateType(readSelfAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadSelfAction_validateMultiplicity(
				readSelfAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateContained constraint of '<em>Read Self Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadSelfAction_validateContained(
			ReadSelfAction readSelfAction, DiagnosticChain diagnostics,
			Map context) {
		return readSelfAction.validateContained(diagnostics, context);
	}

	/**
	 * Validates the validateNotStatic constraint of '<em>Read Self Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadSelfAction_validateNotStatic(
			ReadSelfAction readSelfAction, DiagnosticChain diagnostics,
			Map context) {
		return readSelfAction.validateNotStatic(diagnostics, context);
	}

	/**
	 * Validates the validateType constraint of '<em>Read Self Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadSelfAction_validateType(
			ReadSelfAction readSelfAction, DiagnosticChain diagnostics,
			Map context) {
		return readSelfAction.validateType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Read Self Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadSelfAction_validateMultiplicity(
			ReadSelfAction readSelfAction, DiagnosticChain diagnostics,
			Map context) {
		return readSelfAction.validateMultiplicity(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureAction(
			StructuralFeatureAction structuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(structuralFeatureAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(structuralFeatureAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(structuralFeatureAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateNotStatic(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateSameType(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateMultiplicity(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateVisibility(
				structuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateOneFeaturingClassifier(
				structuralFeatureAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNotStatic constraint of '<em>Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureAction_validateNotStatic(
			StructuralFeatureAction structuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		return structuralFeatureAction.validateNotStatic(diagnostics, context);
	}

	/**
	 * Validates the validateSameType constraint of '<em>Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureAction_validateSameType(
			StructuralFeatureAction structuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		return structuralFeatureAction.validateSameType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureAction_validateMultiplicity(
			StructuralFeatureAction structuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		return structuralFeatureAction.validateMultiplicity(diagnostics,
			context);
	}

	/**
	 * Validates the validateVisibility constraint of '<em>Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureAction_validateVisibility(
			StructuralFeatureAction structuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		return structuralFeatureAction.validateVisibility(diagnostics, context);
	}

	/**
	 * Validates the validateOneFeaturingClassifier constraint of '<em>Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructuralFeatureAction_validateOneFeaturingClassifier(
			StructuralFeatureAction structuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		return structuralFeatureAction.validateOneFeaturingClassifier(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadStructuralFeatureAction(
			ReadStructuralFeatureAction readStructuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(readStructuralFeatureAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateNotStatic(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateSameType(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadStructuralFeatureAction_validateMultiplicity(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateVisibility(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateOneFeaturingClassifier(
				readStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadStructuralFeatureAction_validateTypeAndOrdering(
				readStructuralFeatureAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeAndOrdering constraint of '<em>Read Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadStructuralFeatureAction_validateTypeAndOrdering(
			ReadStructuralFeatureAction readStructuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		return readStructuralFeatureAction.validateTypeAndOrdering(diagnostics,
			context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Read Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadStructuralFeatureAction_validateMultiplicity(
			ReadStructuralFeatureAction readStructuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		// TODO override the constraint, if desired
		// -> uncomment the scaffolding
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericConstraint_diagnostic", new Object[]{"validateMultiplicity", getObjectLabel(readStructuralFeatureAction, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{readStructuralFeatureAction}));
			}
			return false;
		}
		return validateStructuralFeatureAction_validateMultiplicity(
			readStructuralFeatureAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWriteStructuralFeatureAction(
			WriteStructuralFeatureAction writeStructuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(writeStructuralFeatureAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateNotStatic(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateSameType(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateMultiplicity(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateVisibility(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateOneFeaturingClassifier(
				writeStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateInputPin(
				writeStructuralFeatureAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInputPin constraint of '<em>Write Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWriteStructuralFeatureAction_validateInputPin(
			WriteStructuralFeatureAction writeStructuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		return writeStructuralFeatureAction.validateInputPin(diagnostics,
			context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Write Structural Feature Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWriteStructuralFeatureAction_validateMultiplicity(
			WriteStructuralFeatureAction writeStructuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		// TODO override the constraint, if desired
		// -> uncomment the scaffolding
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericConstraint_diagnostic", new Object[]{"validateMultiplicity", getObjectLabel(writeStructuralFeatureAction, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{writeStructuralFeatureAction}));
			}
			return false;
		}
		return validateStructuralFeatureAction_validateMultiplicity(
			writeStructuralFeatureAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClearStructuralFeatureAction(
			ClearStructuralFeatureAction clearStructuralFeatureAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(clearStructuralFeatureAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateNotStatic(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateSameType(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateMultiplicity(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateVisibility(
				clearStructuralFeatureAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateOneFeaturingClassifier(
				clearStructuralFeatureAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRemoveStructuralFeatureValueAction(
			RemoveStructuralFeatureValueAction removeStructuralFeatureValueAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateNotStatic(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateSameType(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateMultiplicity(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateVisibility(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateOneFeaturingClassifier(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateInputPin(
				removeStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRemoveStructuralFeatureValueAction_validateNonUniqueRemoval(
				removeStructuralFeatureValueAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNonUniqueRemoval constraint of '<em>Remove Structural Feature Value Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRemoveStructuralFeatureValueAction_validateNonUniqueRemoval(
			RemoveStructuralFeatureValueAction removeStructuralFeatureValueAction,
			DiagnosticChain diagnostics, Map context) {
		return removeStructuralFeatureValueAction.validateNonUniqueRemoval(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddStructuralFeatureValueAction(
			AddStructuralFeatureValueAction addStructuralFeatureValueAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateNotStatic(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateSameType(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateMultiplicity(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateVisibility(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateOneFeaturingClassifier(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateInputPin(
				addStructuralFeatureValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAddStructuralFeatureValueAction_validateUnlimitedNaturalAndMultiplicity(
				addStructuralFeatureValueAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateUnlimitedNaturalAndMultiplicity constraint of '<em>Add Structural Feature Value Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddStructuralFeatureValueAction_validateUnlimitedNaturalAndMultiplicity(
			AddStructuralFeatureValueAction addStructuralFeatureValueAction,
			DiagnosticChain diagnostics, Map context) {
		return addStructuralFeatureValueAction
			.validateUnlimitedNaturalAndMultiplicity(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkAction(LinkAction linkAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(linkAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(linkAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(linkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(linkAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(linkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(linkAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				linkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(linkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				linkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				linkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				linkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(linkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				linkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSameAssociation(linkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateNotStatic(linkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSamePins(linkAction,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSameAssociation constraint of '<em>Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkAction_validateSameAssociation(
			LinkAction linkAction, DiagnosticChain diagnostics, Map context) {
		return linkAction.validateSameAssociation(diagnostics, context);
	}

	/**
	 * Validates the validateNotStatic constraint of '<em>Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkAction_validateNotStatic(LinkAction linkAction,
			DiagnosticChain diagnostics, Map context) {
		return linkAction.validateNotStatic(diagnostics, context);
	}

	/**
	 * Validates the validateSamePins constraint of '<em>Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkAction_validateSamePins(LinkAction linkAction,
			DiagnosticChain diagnostics, Map context) {
		return linkAction.validateSamePins(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndData(LinkEndData linkEndData,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(linkEndData,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(linkEndData, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(linkEndData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(linkEndData, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(linkEndData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(linkEndData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validatePropertyIsAssociationEnd(
				linkEndData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateSameType(linkEndData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateMultiplicity(linkEndData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateQualifiers(linkEndData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateEndObjectInputPin(
				linkEndData, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validatePropertyIsAssociationEnd constraint of '<em>Link End Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndData_validatePropertyIsAssociationEnd(
			LinkEndData linkEndData, DiagnosticChain diagnostics, Map context) {
		return linkEndData.validatePropertyIsAssociationEnd(diagnostics,
			context);
	}

	/**
	 * Validates the validateSameType constraint of '<em>Link End Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndData_validateSameType(
			LinkEndData linkEndData, DiagnosticChain diagnostics, Map context) {
		return linkEndData.validateSameType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Link End Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndData_validateMultiplicity(
			LinkEndData linkEndData, DiagnosticChain diagnostics, Map context) {
		return linkEndData.validateMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the validateQualifiers constraint of '<em>Link End Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndData_validateQualifiers(
			LinkEndData linkEndData, DiagnosticChain diagnostics, Map context) {
		return linkEndData.validateQualifiers(diagnostics, context);
	}

	/**
	 * Validates the validateEndObjectInputPin constraint of '<em>Link End Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndData_validateEndObjectInputPin(
			LinkEndData linkEndData, DiagnosticChain diagnostics, Map context) {
		return linkEndData.validateEndObjectInputPin(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifierValue(QualifierValue qualifierValue,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(qualifierValue,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(qualifierValue,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(qualifierValue,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(qualifierValue, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(qualifierValue,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(qualifierValue,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateQualifierValue_validateQualifierAttribute(
				qualifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateQualifierValue_validateTypeOfQualifier(
				qualifierValue, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateQualifierValue_validateMultiplicityOfQualifier(
				qualifierValue, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateQualifierAttribute constraint of '<em>Qualifier Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifierValue_validateQualifierAttribute(
			QualifierValue qualifierValue, DiagnosticChain diagnostics,
			Map context) {
		return qualifierValue.validateQualifierAttribute(diagnostics, context);
	}

	/**
	 * Validates the validateTypeOfQualifier constraint of '<em>Qualifier Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifierValue_validateTypeOfQualifier(
			QualifierValue qualifierValue, DiagnosticChain diagnostics,
			Map context) {
		return qualifierValue.validateTypeOfQualifier(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicityOfQualifier constraint of '<em>Qualifier Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifierValue_validateMultiplicityOfQualifier(
			QualifierValue qualifierValue, DiagnosticChain diagnostics,
			Map context) {
		return qualifierValue.validateMultiplicityOfQualifier(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkAction(ReadLinkAction readLinkAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(readLinkAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(readLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(readLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(readLinkAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(readLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(readLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(readLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSameAssociation(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateNotStatic(readLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSamePins(readLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkAction_validateOneOpenEnd(readLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkAction_validateTypeAndOrdering(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkAction_validateCompatibleMultiplicity(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkAction_validateNavigableOpenEnd(
				readLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkAction_validateVisibility(readLinkAction,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOneOpenEnd constraint of '<em>Read Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkAction_validateOneOpenEnd(
			ReadLinkAction readLinkAction, DiagnosticChain diagnostics,
			Map context) {
		return readLinkAction.validateOneOpenEnd(diagnostics, context);
	}

	/**
	 * Validates the validateTypeAndOrdering constraint of '<em>Read Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkAction_validateTypeAndOrdering(
			ReadLinkAction readLinkAction, DiagnosticChain diagnostics,
			Map context) {
		return readLinkAction.validateTypeAndOrdering(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleMultiplicity constraint of '<em>Read Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkAction_validateCompatibleMultiplicity(
			ReadLinkAction readLinkAction, DiagnosticChain diagnostics,
			Map context) {
		return readLinkAction.validateCompatibleMultiplicity(diagnostics,
			context);
	}

	/**
	 * Validates the validateNavigableOpenEnd constraint of '<em>Read Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkAction_validateNavigableOpenEnd(
			ReadLinkAction readLinkAction, DiagnosticChain diagnostics,
			Map context) {
		return readLinkAction.validateNavigableOpenEnd(diagnostics, context);
	}

	/**
	 * Validates the validateVisibility constraint of '<em>Read Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkAction_validateVisibility(
			ReadLinkAction readLinkAction, DiagnosticChain diagnostics,
			Map context) {
		return readLinkAction.validateVisibility(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndCreationData(
			LinkEndCreationData linkEndCreationData,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			linkEndCreationData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(linkEndCreationData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(linkEndCreationData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(linkEndCreationData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(linkEndCreationData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(linkEndCreationData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validatePropertyIsAssociationEnd(
				linkEndCreationData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateSameType(linkEndCreationData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateMultiplicity(
				linkEndCreationData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateQualifiers(
				linkEndCreationData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateEndObjectInputPin(
				linkEndCreationData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndCreationData_validateCreateLinkAction(
				linkEndCreationData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndCreationData_validateSingleInputPin(
				linkEndCreationData, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCreateLinkAction constraint of '<em>Link End Creation Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndCreationData_validateCreateLinkAction(
			LinkEndCreationData linkEndCreationData,
			DiagnosticChain diagnostics, Map context) {
		return linkEndCreationData.validateCreateLinkAction(diagnostics,
			context);
	}

	/**
	 * Validates the validateSingleInputPin constraint of '<em>Link End Creation Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndCreationData_validateSingleInputPin(
			LinkEndCreationData linkEndCreationData,
			DiagnosticChain diagnostics, Map context) {
		return linkEndCreationData.validateSingleInputPin(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateLinkAction(CreateLinkAction createLinkAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(createLinkAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(createLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(createLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(createLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(createLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(createLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				createLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				createLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				createLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				createLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				createLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(createLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				createLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSameAssociation(
				createLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateNotStatic(createLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSamePins(createLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteLinkAction_validateAllowAccess(
				createLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateLinkAction_validateAssociationNotAbstract(
				createLinkAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateAssociationNotAbstract constraint of '<em>Create Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateLinkAction_validateAssociationNotAbstract(
			CreateLinkAction createLinkAction, DiagnosticChain diagnostics,
			Map context) {
		return createLinkAction.validateAssociationNotAbstract(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWriteLinkAction(WriteLinkAction writeLinkAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(writeLinkAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(writeLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(writeLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(writeLinkAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(writeLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(writeLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				writeLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				writeLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				writeLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				writeLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				writeLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(writeLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				writeLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSameAssociation(
				writeLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateNotStatic(writeLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSamePins(writeLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteLinkAction_validateAllowAccess(
				writeLinkAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateAllowAccess constraint of '<em>Write Link Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWriteLinkAction_validateAllowAccess(
			WriteLinkAction writeLinkAction, DiagnosticChain diagnostics,
			Map context) {
		return writeLinkAction.validateAllowAccess(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDestroyLinkAction(
			DestroyLinkAction destroyLinkAction, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(destroyLinkAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(destroyLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(destroyLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(destroyLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(destroyLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(destroyLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				destroyLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				destroyLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				destroyLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				destroyLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				destroyLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(destroyLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				destroyLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSameAssociation(
				destroyLinkAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateNotStatic(destroyLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSamePins(destroyLinkAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteLinkAction_validateAllowAccess(
				destroyLinkAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndDestructionData(
			LinkEndDestructionData linkEndDestructionData,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(linkEndDestructionData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(linkEndDestructionData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(linkEndDestructionData,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validatePropertyIsAssociationEnd(
				linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateSameType(
				linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateMultiplicity(
				linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateQualifiers(
				linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndData_validateEndObjectInputPin(
				linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndDestructionData_validateDestroyLinkAction(
				linkEndDestructionData, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkEndDestructionData_validateUnlimitedNaturalAndMultiplicity(
				linkEndDestructionData, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDestroyLinkAction constraint of '<em>Link End Destruction Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndDestructionData_validateDestroyLinkAction(
			LinkEndDestructionData linkEndDestructionData,
			DiagnosticChain diagnostics, Map context) {
		return linkEndDestructionData.validateDestroyLinkAction(diagnostics,
			context);
	}

	/**
	 * Validates the validateUnlimitedNaturalAndMultiplicity constraint of '<em>Link End Destruction Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLinkEndDestructionData_validateUnlimitedNaturalAndMultiplicity(
			LinkEndDestructionData linkEndDestructionData,
			DiagnosticChain diagnostics, Map context) {
		return linkEndDestructionData.validateUnlimitedNaturalAndMultiplicity(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClearAssociationAction(
			ClearAssociationAction clearAssociationAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(clearAssociationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(clearAssociationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(clearAssociationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClearAssociationAction_validateSameType(
				clearAssociationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClearAssociationAction_validateMultiplicity(
				clearAssociationAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSameType constraint of '<em>Clear Association Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClearAssociationAction_validateSameType(
			ClearAssociationAction clearAssociationAction,
			DiagnosticChain diagnostics, Map context) {
		return clearAssociationAction.validateSameType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Clear Association Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClearAssociationAction_validateMultiplicity(
			ClearAssociationAction clearAssociationAction,
			DiagnosticChain diagnostics, Map context) {
		return clearAssociationAction
			.validateMultiplicity(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBroadcastSignalAction(
			BroadcastSignalAction broadcastSignalAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(broadcastSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(broadcastSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(broadcastSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(broadcastSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(broadcastSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(broadcastSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInvocationAction_validateOnPortReceiver(
				broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBroadcastSignalAction_validateNumberAndOrder(
				broadcastSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBroadcastSignalAction_validateTypeOrderingMultiplicity(
				broadcastSignalAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNumberAndOrder constraint of '<em>Broadcast Signal Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBroadcastSignalAction_validateNumberAndOrder(
			BroadcastSignalAction broadcastSignalAction,
			DiagnosticChain diagnostics, Map context) {
		return broadcastSignalAction.validateNumberAndOrder(diagnostics,
			context);
	}

	/**
	 * Validates the validateTypeOrderingMultiplicity constraint of '<em>Broadcast Signal Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBroadcastSignalAction_validateTypeOrderingMultiplicity(
			BroadcastSignalAction broadcastSignalAction,
			DiagnosticChain diagnostics, Map context) {
		return broadcastSignalAction.validateTypeOrderingMultiplicity(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationAction(InvocationAction invocationAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(invocationAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(invocationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(invocationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(invocationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(invocationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(invocationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				invocationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				invocationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				invocationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				invocationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				invocationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(invocationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				invocationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInvocationAction_validateOnPortReceiver(
				invocationAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOnPortReceiver constraint of '<em>Invocation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvocationAction_validateOnPortReceiver(
			InvocationAction invocationAction, DiagnosticChain diagnostics,
			Map context) {
		return invocationAction.validateOnPortReceiver(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendObjectAction(SendObjectAction sendObjectAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(sendObjectAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(sendObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(sendObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(sendObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(sendObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(sendObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				sendObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				sendObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				sendObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				sendObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				sendObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(sendObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				sendObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInvocationAction_validateOnPortReceiver(
				sendObjectAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueSpecificationAction(
			ValueSpecificationAction valueSpecificationAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(valueSpecificationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(valueSpecificationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateValueSpecificationAction_validateCompatibleType(
				valueSpecificationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateValueSpecificationAction_validateMultiplicity(
				valueSpecificationAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleType constraint of '<em>Value Specification Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueSpecificationAction_validateCompatibleType(
			ValueSpecificationAction valueSpecificationAction,
			DiagnosticChain diagnostics, Map context) {
		return valueSpecificationAction.validateCompatibleType(diagnostics,
			context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Value Specification Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueSpecificationAction_validateMultiplicity(
			ValueSpecificationAction valueSpecificationAction,
			DiagnosticChain diagnostics, Map context) {
		return valueSpecificationAction.validateMultiplicity(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeExpression(TimeExpression timeExpression,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(timeExpression,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(timeExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(timeExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(timeExpression, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(timeExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(timeExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				timeExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				timeExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				timeExpression, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDuration(Duration duration,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(duration,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(duration, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(duration, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(duration, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(duration, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(duration, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(duration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(duration,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				duration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeObservationAction(
			TimeObservationAction timeObservationAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(timeObservationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(timeObservationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(timeObservationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(timeObservationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(timeObservationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(timeObservationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateNotStatic(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateSameType(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateMultiplicity(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateVisibility(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateOneFeaturingClassifier(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateInputPin(
				timeObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTimeObservationAction_validateInputValueTimeExpression(
				timeObservationAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInputValueTimeExpression constraint of '<em>Time Observation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeObservationAction_validateInputValueTimeExpression(
			TimeObservationAction timeObservationAction,
			DiagnosticChain diagnostics, Map context) {
		return timeObservationAction.validateInputValueTimeExpression(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValuePin(ValuePin valuePin,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(valuePin,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(valuePin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(valuePin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(valuePin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(valuePin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(valuePin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(valuePin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(valuePin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				valuePin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				valuePin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				valuePin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(valuePin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				valuePin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(valuePin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(valuePin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(valuePin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(valuePin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePin_validateControlPins(valuePin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateValuePin_validateCompatibleType(valuePin,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleType constraint of '<em>Value Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValuePin_validateCompatibleType(ValuePin valuePin,
			DiagnosticChain diagnostics, Map context) {
		return valuePin.validateCompatibleType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDurationInterval(DurationInterval durationInterval,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(durationInterval,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(durationInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(durationInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(durationInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(durationInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(durationInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				durationInterval, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				durationInterval, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				durationInterval, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInterval(Interval interval,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(interval,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(interval, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(interval, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(interval, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(interval, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(interval, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(interval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(interval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				interval, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeConstraint(TimeConstraint timeConstraint,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(timeConstraint,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(timeConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(timeConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(timeConstraint, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(timeConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(timeConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				timeConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				timeConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				timeConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotApplyToSelf(timeConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateValueSpecificationBoolean(
				timeConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateBooleanValue(timeConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNoSideEffects(timeConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotAppliedToSelf(
				timeConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntervalConstraint(
			IntervalConstraint intervalConstraint, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(intervalConstraint,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(intervalConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(intervalConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(intervalConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(intervalConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(intervalConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				intervalConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				intervalConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				intervalConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotApplyToSelf(
				intervalConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateValueSpecificationBoolean(
				intervalConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateBooleanValue(
				intervalConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNoSideEffects(
				intervalConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotAppliedToSelf(
				intervalConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeInterval(TimeInterval timeInterval,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(timeInterval,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(timeInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(timeInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(timeInterval, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(timeInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(timeInterval,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				timeInterval, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				timeInterval, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				timeInterval, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDurationObservationAction(
			DurationObservationAction durationObservationAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(durationObservationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateNotStatic(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateSameType(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateMultiplicity(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateVisibility(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuralFeatureAction_validateOneFeaturingClassifier(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteStructuralFeatureAction_validateInputPin(
				durationObservationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDurationObservationAction_validateInputValueDuration(
				durationObservationAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInputValueDuration constraint of '<em>Duration Observation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDurationObservationAction_validateInputValueDuration(
			DurationObservationAction durationObservationAction,
			DiagnosticChain diagnostics, Map context) {
		return durationObservationAction.validateInputValueDuration(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDurationConstraint(
			DurationConstraint durationConstraint, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(durationConstraint,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(durationConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(durationConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(durationConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(durationConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(durationConstraint,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				durationConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				durationConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				durationConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotApplyToSelf(
				durationConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateValueSpecificationBoolean(
				durationConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateBooleanValue(
				durationConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNoSideEffects(
				durationConstraint, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConstraint_validateNotAppliedToSelf(
				durationConstraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueAction(OpaqueAction opaqueAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(opaqueAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(opaqueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(opaqueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(opaqueAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(opaqueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(opaqueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				opaqueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				opaqueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				opaqueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				opaqueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				opaqueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(opaqueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				opaqueAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallAction(CallAction callAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(callAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(callAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(callAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(callAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(callAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(callAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				callAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(callAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				callAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				callAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				callAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(callAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				callAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInvocationAction_validateOnPortReceiver(
				callAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallAction_validateSynchronousCall(callAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallAction_validateNumberAndOrder(callAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallAction_validateTypeOrderingMultiplicity(
				callAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSynchronousCall constraint of '<em>Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallAction_validateSynchronousCall(
			CallAction callAction, DiagnosticChain diagnostics, Map context) {
		return callAction.validateSynchronousCall(diagnostics, context);
	}

	/**
	 * Validates the validateNumberAndOrder constraint of '<em>Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallAction_validateNumberAndOrder(
			CallAction callAction, DiagnosticChain diagnostics, Map context) {
		return callAction.validateNumberAndOrder(diagnostics, context);
	}

	/**
	 * Validates the validateTypeOrderingMultiplicity constraint of '<em>Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallAction_validateTypeOrderingMultiplicity(
			CallAction callAction, DiagnosticChain diagnostics, Map context) {
		return callAction
			.validateTypeOrderingMultiplicity(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendSignalAction(SendSignalAction sendSignalAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(sendSignalAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(sendSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(sendSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(sendSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(sendSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(sendSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				sendSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				sendSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				sendSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				sendSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				sendSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(sendSignalAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				sendSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInvocationAction_validateOnPortReceiver(
				sendSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateSendSignalAction_validateNumberOrder(
				sendSignalAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateSendSignalAction_validateTypeOrderingMultiplicity(
				sendSignalAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNumberOrder constraint of '<em>Send Signal Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendSignalAction_validateNumberOrder(
			SendSignalAction sendSignalAction, DiagnosticChain diagnostics,
			Map context) {
		return sendSignalAction.validateNumberOrder(diagnostics, context);
	}

	/**
	 * Validates the validateTypeOrderingMultiplicity constraint of '<em>Send Signal Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendSignalAction_validateTypeOrderingMultiplicity(
			SendSignalAction sendSignalAction, DiagnosticChain diagnostics,
			Map context) {
		return sendSignalAction.validateTypeOrderingMultiplicity(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallOperationAction(
			CallOperationAction callOperationAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(callOperationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(callOperationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(callOperationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(callOperationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(callOperationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(callOperationAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInvocationAction_validateOnPortReceiver(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallAction_validateSynchronousCall(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallAction_validateNumberAndOrder(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallOperationAction_validateTypeOrderingMultiplicity(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallOperationAction_validateArgumentPinEqualParameter(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallOperationAction_validateResultPinEqualParameter(
				callOperationAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallOperationAction_validateTypeTargetPin(
				callOperationAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateArgumentPinEqualParameter constraint of '<em>Call Operation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallOperationAction_validateArgumentPinEqualParameter(
			CallOperationAction callOperationAction,
			DiagnosticChain diagnostics, Map context) {
		return callOperationAction.validateArgumentPinEqualParameter(
			diagnostics, context);
	}

	/**
	 * Validates the validateResultPinEqualParameter constraint of '<em>Call Operation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallOperationAction_validateResultPinEqualParameter(
			CallOperationAction callOperationAction,
			DiagnosticChain diagnostics, Map context) {
		return callOperationAction.validateResultPinEqualParameter(diagnostics,
			context);
	}

	/**
	 * Validates the validateTypeTargetPin constraint of '<em>Call Operation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallOperationAction_validateTypeTargetPin(
			CallOperationAction callOperationAction,
			DiagnosticChain diagnostics, Map context) {
		return callOperationAction.validateTypeTargetPin(diagnostics, context);
	}

	/**
	 * Validates the validateTypeOrderingMultiplicity constraint of '<em>Call Operation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallOperationAction_validateTypeOrderingMultiplicity(
			CallOperationAction callOperationAction,
			DiagnosticChain diagnostics, Map context) {
		// TODO override the constraint, if desired
		// -> uncomment the scaffolding
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericConstraint_diagnostic", new Object[]{"validateTypeOrderingMultiplicity", getObjectLabel(callOperationAction, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{callOperationAction}));
			}
			return false;
		}
		return validateCallAction_validateTypeOrderingMultiplicity(
			callOperationAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallBehaviorAction(
			CallBehaviorAction callBehaviorAction, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(callBehaviorAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(callBehaviorAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(callBehaviorAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(callBehaviorAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(callBehaviorAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(callBehaviorAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(callBehaviorAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInvocationAction_validateOnPortReceiver(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallAction_validateSynchronousCall(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallAction_validateNumberAndOrder(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallBehaviorAction_validateTypeOrderingMultiplicity(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallBehaviorAction_validateArgumentPinEqualParameter(
				callBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCallBehaviorAction_validateResultPinEqualParameter(
				callBehaviorAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateArgumentPinEqualParameter constraint of '<em>Call Behavior Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallBehaviorAction_validateArgumentPinEqualParameter(
			CallBehaviorAction callBehaviorAction, DiagnosticChain diagnostics,
			Map context) {
		return callBehaviorAction.validateArgumentPinEqualParameter(
			diagnostics, context);
	}

	/**
	 * Validates the validateResultPinEqualParameter constraint of '<em>Call Behavior Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallBehaviorAction_validateResultPinEqualParameter(
			CallBehaviorAction callBehaviorAction, DiagnosticChain diagnostics,
			Map context) {
		return callBehaviorAction.validateResultPinEqualParameter(diagnostics,
			context);
	}

	/**
	 * Validates the validateTypeOrderingMultiplicity constraint of '<em>Call Behavior Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallBehaviorAction_validateTypeOrderingMultiplicity(
			CallBehaviorAction callBehaviorAction, DiagnosticChain diagnostics,
			Map context) {
		// TODO override the constraint, if desired
		// -> uncomment the scaffolding
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericConstraint_diagnostic", new Object[]{"validateTypeOrderingMultiplicity", getObjectLabel(callBehaviorAction, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{callBehaviorAction}));
			}
			return false;
		}
		return validateCallAction_validateTypeOrderingMultiplicity(
			callBehaviorAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInformationItem(InformationItem informationItem,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(informationItem,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(informationItem,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(informationItem,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(informationItem, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(informationItem,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(informationItem,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInformationItem_validateSourcesAndTargets(
				informationItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInformationItem_validateHasNo(informationItem,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInformationItem_validateNotInstantiable(
				informationItem, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSourcesAndTargets constraint of '<em>Information Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInformationItem_validateSourcesAndTargets(
			InformationItem informationItem, DiagnosticChain diagnostics,
			Map context) {
		return informationItem.validateSourcesAndTargets(diagnostics, context);
	}

	/**
	 * Validates the validateHasNo constraint of '<em>Information Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInformationItem_validateHasNo(
			InformationItem informationItem, DiagnosticChain diagnostics,
			Map context) {
		return informationItem.validateHasNo(diagnostics, context);
	}

	/**
	 * Validates the validateNotInstantiable constraint of '<em>Information Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInformationItem_validateNotInstantiable(
			InformationItem informationItem, DiagnosticChain diagnostics,
			Map context) {
		return informationItem.validateNotInstantiable(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInformationFlow(InformationFlow informationFlow,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(informationFlow,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(informationFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(informationFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(informationFlow, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(informationFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(informationFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				informationFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				informationFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				informationFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInformationFlow_validateSourcesAndTargetsKind(
				informationFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInformationFlow_validateMustConform(
				informationFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInformationFlow_validateConveyClassifiers(
				informationFlow, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSourcesAndTargetsKind constraint of '<em>Information Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInformationFlow_validateSourcesAndTargetsKind(
			InformationFlow informationFlow, DiagnosticChain diagnostics,
			Map context) {
		return informationFlow.validateSourcesAndTargetsKind(diagnostics,
			context);
	}

	/**
	 * Validates the validateMustConform constraint of '<em>Information Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInformationFlow_validateMustConform(
			InformationFlow informationFlow, DiagnosticChain diagnostics,
			Map context) {
		return informationFlow.validateMustConform(diagnostics, context);
	}

	/**
	 * Validates the validateConveyClassifiers constraint of '<em>Information Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInformationFlow_validateConveyClassifiers(
			InformationFlow informationFlow, DiagnosticChain diagnostics,
			Map context) {
		return informationFlow.validateConveyClassifiers(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModel(Model model, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(model, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(model, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(model, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(model, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(model, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(model, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(model,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(model,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				model, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(model,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePackage_validateElementsPublicOrPrivate(model,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableAction(VariableAction variableAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(variableAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(variableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(variableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(variableAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(variableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(variableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				variableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				variableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				variableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				variableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				variableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(variableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				variableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateVariableAction_validateScopeOfVariable(
				variableAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateScopeOfVariable constraint of '<em>Variable Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableAction_validateScopeOfVariable(
			VariableAction variableAction, DiagnosticChain diagnostics,
			Map context) {
		return variableAction.validateScopeOfVariable(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadVariableAction(
			ReadVariableAction readVariableAction, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(readVariableAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(readVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(readVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(readVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(readVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(readVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				readVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				readVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				readVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				readVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				readVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(readVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				readVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateVariableAction_validateScopeOfVariable(
				readVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadVariableAction_validateTypeAndOrdering(
				readVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadVariableAction_validateCompatibleMultiplicity(
				readVariableAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeAndOrdering constraint of '<em>Read Variable Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadVariableAction_validateTypeAndOrdering(
			ReadVariableAction readVariableAction, DiagnosticChain diagnostics,
			Map context) {
		return readVariableAction.validateTypeAndOrdering(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleMultiplicity constraint of '<em>Read Variable Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadVariableAction_validateCompatibleMultiplicity(
			ReadVariableAction readVariableAction, DiagnosticChain diagnostics,
			Map context) {
		return readVariableAction.validateCompatibleMultiplicity(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWriteVariableAction(
			WriteVariableAction writeVariableAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(writeVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(writeVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(writeVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(writeVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(writeVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(writeVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateVariableAction_validateScopeOfVariable(
				writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteVariableAction_validateSameType(
				writeVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteVariableAction_validateMultiplicity(
				writeVariableAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSameType constraint of '<em>Write Variable Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWriteVariableAction_validateSameType(
			WriteVariableAction writeVariableAction,
			DiagnosticChain diagnostics, Map context) {
		return writeVariableAction.validateSameType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Write Variable Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWriteVariableAction_validateMultiplicity(
			WriteVariableAction writeVariableAction,
			DiagnosticChain diagnostics, Map context) {
		return writeVariableAction.validateMultiplicity(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClearVariableAction(
			ClearVariableAction clearVariableAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			clearVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(clearVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(clearVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(clearVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(clearVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(clearVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				clearVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				clearVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				clearVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				clearVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				clearVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(clearVariableAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				clearVariableAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateVariableAction_validateScopeOfVariable(
				clearVariableAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddVariableValueAction(
			AddVariableValueAction addVariableValueAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(addVariableValueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(addVariableValueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(addVariableValueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateVariableAction_validateScopeOfVariable(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteVariableAction_validateSameType(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteVariableAction_validateMultiplicity(
				addVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAddVariableValueAction_validateSingleInputPin(
				addVariableValueAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSingleInputPin constraint of '<em>Add Variable Value Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddVariableValueAction_validateSingleInputPin(
			AddVariableValueAction addVariableValueAction,
			DiagnosticChain diagnostics, Map context) {
		return addVariableValueAction.validateSingleInputPin(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRemoveVariableValueAction(
			RemoveVariableValueAction removeVariableValueAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(removeVariableValueAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateVariableAction_validateScopeOfVariable(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteVariableAction_validateSameType(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteVariableAction_validateMultiplicity(
				removeVariableValueAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRemoveVariableValueAction_validateUnlimitedNatural(
				removeVariableValueAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateUnlimitedNatural constraint of '<em>Remove Variable Value Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRemoveVariableValueAction_validateUnlimitedNatural(
			RemoveVariableValueAction removeVariableValueAction,
			DiagnosticChain diagnostics, Map context) {
		return removeVariableValueAction.validateUnlimitedNatural(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRaiseExceptionAction(
			RaiseExceptionAction raiseExceptionAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			raiseExceptionAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(raiseExceptionAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(raiseExceptionAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(raiseExceptionAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(raiseExceptionAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(raiseExceptionAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				raiseExceptionAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				raiseExceptionAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				raiseExceptionAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				raiseExceptionAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				raiseExceptionAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(raiseExceptionAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				raiseExceptionAction, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionInputPin(ActionInputPin actionInputPin,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(actionInputPin,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(actionInputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(actionInputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(actionInputPin, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(actionInputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(actionInputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(actionInputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(actionInputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validatePin_validateControlPins(actionInputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActionInputPin_validateOneOutputPin(
				actionInputPin, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActionInputPin_validateInputPin(actionInputPin,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActionInputPin_validateNoControlOrDataFlow(
				actionInputPin, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOneOutputPin constraint of '<em>Action Input Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionInputPin_validateOneOutputPin(
			ActionInputPin actionInputPin, DiagnosticChain diagnostics,
			Map context) {
		return actionInputPin.validateOneOutputPin(diagnostics, context);
	}

	/**
	 * Validates the validateInputPin constraint of '<em>Action Input Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionInputPin_validateInputPin(
			ActionInputPin actionInputPin, DiagnosticChain diagnostics,
			Map context) {
		return actionInputPin.validateInputPin(diagnostics, context);
	}

	/**
	 * Validates the validateNoControlOrDataFlow constraint of '<em>Action Input Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionInputPin_validateNoControlOrDataFlow(
			ActionInputPin actionInputPin, DiagnosticChain diagnostics,
			Map context) {
		return actionInputPin.validateNoControlOrDataFlow(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadExtentAction(ReadExtentAction readExtentAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(readExtentAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(readExtentAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(readExtentAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(readExtentAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(readExtentAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(readExtentAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				readExtentAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				readExtentAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				readExtentAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				readExtentAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				readExtentAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(readExtentAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				readExtentAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadExtentAction_validateTypeIsClassifier(
				readExtentAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadExtentAction_validateMultiplicityOfResult(
				readExtentAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsClassifier constraint of '<em>Read Extent Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadExtentAction_validateTypeIsClassifier(
			ReadExtentAction readExtentAction, DiagnosticChain diagnostics,
			Map context) {
		return readExtentAction.validateTypeIsClassifier(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicityOfResult constraint of '<em>Read Extent Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadExtentAction_validateMultiplicityOfResult(
			ReadExtentAction readExtentAction, DiagnosticChain diagnostics,
			Map context) {
		return readExtentAction.validateMultiplicityOfResult(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReclassifyObjectAction(
			ReclassifyObjectAction reclassifyObjectAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(reclassifyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(reclassifyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(reclassifyObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReclassifyObjectAction_validateClassifierNotAbstract(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReclassifyObjectAction_validateMultiplicity(
				reclassifyObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReclassifyObjectAction_validateInputPin(
				reclassifyObjectAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateClassifierNotAbstract constraint of '<em>Reclassify Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReclassifyObjectAction_validateClassifierNotAbstract(
			ReclassifyObjectAction reclassifyObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return reclassifyObjectAction.validateClassifierNotAbstract(
			diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Reclassify Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReclassifyObjectAction_validateMultiplicity(
			ReclassifyObjectAction reclassifyObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return reclassifyObjectAction
			.validateMultiplicity(diagnostics, context);
	}

	/**
	 * Validates the validateInputPin constraint of '<em>Reclassify Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReclassifyObjectAction_validateInputPin(
			ReclassifyObjectAction reclassifyObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return reclassifyObjectAction.validateInputPin(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadIsClassifiedObjectAction(
			ReadIsClassifiedObjectAction readIsClassifiedObjectAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(readIsClassifiedObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadIsClassifiedObjectAction_validateMultiplicityOfInput(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadIsClassifiedObjectAction_validateNoType(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadIsClassifiedObjectAction_validateMultiplicityOfOutput(
				readIsClassifiedObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadIsClassifiedObjectAction_validateBooleanResult(
				readIsClassifiedObjectAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMultiplicityOfInput constraint of '<em>Read Is Classified Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadIsClassifiedObjectAction_validateMultiplicityOfInput(
			ReadIsClassifiedObjectAction readIsClassifiedObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return readIsClassifiedObjectAction.validateMultiplicityOfInput(
			diagnostics, context);
	}

	/**
	 * Validates the validateNoType constraint of '<em>Read Is Classified Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadIsClassifiedObjectAction_validateNoType(
			ReadIsClassifiedObjectAction readIsClassifiedObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return readIsClassifiedObjectAction
			.validateNoType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicityOfOutput constraint of '<em>Read Is Classified Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadIsClassifiedObjectAction_validateMultiplicityOfOutput(
			ReadIsClassifiedObjectAction readIsClassifiedObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return readIsClassifiedObjectAction.validateMultiplicityOfOutput(
			diagnostics, context);
	}

	/**
	 * Validates the validateBooleanResult constraint of '<em>Read Is Classified Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadIsClassifiedObjectAction_validateBooleanResult(
			ReadIsClassifiedObjectAction readIsClassifiedObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return readIsClassifiedObjectAction.validateBooleanResult(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStartClassifierBehaviorAction(
			StartClassifierBehaviorAction startClassifierBehaviorAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStartClassifierBehaviorAction_validateMultiplicity(
				startClassifierBehaviorAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStartClassifierBehaviorAction_validateTypeHasClassifier(
				startClassifierBehaviorAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Start Classifier Behavior Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStartClassifierBehaviorAction_validateMultiplicity(
			StartClassifierBehaviorAction startClassifierBehaviorAction,
			DiagnosticChain diagnostics, Map context) {
		return startClassifierBehaviorAction.validateMultiplicity(diagnostics,
			context);
	}

	/**
	 * Validates the validateTypeHasClassifier constraint of '<em>Start Classifier Behavior Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStartClassifierBehaviorAction_validateTypeHasClassifier(
			StartClassifierBehaviorAction startClassifierBehaviorAction,
			DiagnosticChain diagnostics, Map context) {
		return startClassifierBehaviorAction.validateTypeHasClassifier(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndAction(
			ReadLinkObjectEndAction readLinkObjectEndAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(readLinkObjectEndAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(readLinkObjectEndAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(readLinkObjectEndAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndAction_validateProperty(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndAction_validateAssociationOfAssociation(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndAction_validateEndsOfAssociation(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndAction_validateTypeOfObject(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndAction_validateMultiplicityOfObject(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndAction_validateTypeOfResult(
				readLinkObjectEndAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndAction_validateMultiplicityOfResult(
				readLinkObjectEndAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateProperty constraint of '<em>Read Link Object End Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndAction_validateProperty(
			ReadLinkObjectEndAction readLinkObjectEndAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndAction.validateProperty(diagnostics, context);
	}

	/**
	 * Validates the validateAssociationOfAssociation constraint of '<em>Read Link Object End Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndAction_validateAssociationOfAssociation(
			ReadLinkObjectEndAction readLinkObjectEndAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndAction.validateAssociationOfAssociation(
			diagnostics, context);
	}

	/**
	 * Validates the validateEndsOfAssociation constraint of '<em>Read Link Object End Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndAction_validateEndsOfAssociation(
			ReadLinkObjectEndAction readLinkObjectEndAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndAction.validateEndsOfAssociation(diagnostics,
			context);
	}

	/**
	 * Validates the validateTypeOfObject constraint of '<em>Read Link Object End Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndAction_validateTypeOfObject(
			ReadLinkObjectEndAction readLinkObjectEndAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndAction.validateTypeOfObject(diagnostics,
			context);
	}

	/**
	 * Validates the validateMultiplicityOfObject constraint of '<em>Read Link Object End Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndAction_validateMultiplicityOfObject(
			ReadLinkObjectEndAction readLinkObjectEndAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndAction.validateMultiplicityOfObject(
			diagnostics, context);
	}

	/**
	 * Validates the validateTypeOfResult constraint of '<em>Read Link Object End Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndAction_validateTypeOfResult(
			ReadLinkObjectEndAction readLinkObjectEndAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndAction.validateTypeOfResult(diagnostics,
			context);
	}

	/**
	 * Validates the validateMultiplicityOfResult constraint of '<em>Read Link Object End Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndAction_validateMultiplicityOfResult(
			ReadLinkObjectEndAction readLinkObjectEndAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndAction.validateMultiplicityOfResult(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndQualifierAction_validateQualifierAttribute(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndQualifierAction_validateAssociationOfAssociation(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndQualifierAction_validateEndsOfAssociation(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndQualifierAction_validateTypeOfObject(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndQualifierAction_validateMultiplicityOfQualifier(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndQualifierAction_validateMultiplicityOfObject(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndQualifierAction_validateSameType(
				readLinkObjectEndQualifierAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReadLinkObjectEndQualifierAction_validateMultiplicityOfResult(
				readLinkObjectEndQualifierAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateQualifierAttribute constraint of '<em>Read Link Object End Qualifier Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction_validateQualifierAttribute(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndQualifierAction.validateQualifierAttribute(
			diagnostics, context);
	}

	/**
	 * Validates the validateAssociationOfAssociation constraint of '<em>Read Link Object End Qualifier Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction_validateAssociationOfAssociation(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndQualifierAction
			.validateAssociationOfAssociation(diagnostics, context);
	}

	/**
	 * Validates the validateEndsOfAssociation constraint of '<em>Read Link Object End Qualifier Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction_validateEndsOfAssociation(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndQualifierAction.validateEndsOfAssociation(
			diagnostics, context);
	}

	/**
	 * Validates the validateTypeOfObject constraint of '<em>Read Link Object End Qualifier Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction_validateTypeOfObject(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndQualifierAction.validateTypeOfObject(
			diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicityOfQualifier constraint of '<em>Read Link Object End Qualifier Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction_validateMultiplicityOfQualifier(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndQualifierAction
			.validateMultiplicityOfQualifier(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicityOfObject constraint of '<em>Read Link Object End Qualifier Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction_validateMultiplicityOfObject(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndQualifierAction.validateMultiplicityOfObject(
			diagnostics, context);
	}

	/**
	 * Validates the validateSameType constraint of '<em>Read Link Object End Qualifier Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction_validateSameType(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndQualifierAction.validateSameType(diagnostics,
			context);
	}

	/**
	 * Validates the validateMultiplicityOfResult constraint of '<em>Read Link Object End Qualifier Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadLinkObjectEndQualifierAction_validateMultiplicityOfResult(
			ReadLinkObjectEndQualifierAction readLinkObjectEndQualifierAction,
			DiagnosticChain diagnostics, Map context) {
		return readLinkObjectEndQualifierAction.validateMultiplicityOfResult(
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateLinkObjectAction(
			CreateLinkObjectAction createLinkObjectAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(createLinkObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(createLinkObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(createLinkObjectAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSameAssociation(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateNotStatic(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLinkAction_validateSamePins(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateWriteLinkAction_validateAllowAccess(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateLinkAction_validateAssociationNotAbstract(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateLinkObjectAction_validateAssociationClass(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateLinkObjectAction_validateTypeOfResult(
				createLinkObjectAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCreateLinkObjectAction_validateMultiplicity(
				createLinkObjectAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateAssociationClass constraint of '<em>Create Link Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateLinkObjectAction_validateAssociationClass(
			CreateLinkObjectAction createLinkObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return createLinkObjectAction.validateAssociationClass(diagnostics,
			context);
	}

	/**
	 * Validates the validateTypeOfResult constraint of '<em>Create Link Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateLinkObjectAction_validateTypeOfResult(
			CreateLinkObjectAction createLinkObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return createLinkObjectAction
			.validateTypeOfResult(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicity constraint of '<em>Create Link Object Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCreateLinkObjectAction_validateMultiplicity(
			CreateLinkObjectAction createLinkObjectAction,
			DiagnosticChain diagnostics, Map context) {
		return createLinkObjectAction
			.validateMultiplicity(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptEventAction(
			AcceptEventAction acceptEventAction, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(acceptEventAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(acceptEventAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(acceptEventAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(acceptEventAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(acceptEventAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(acceptEventAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(acceptEventAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptEventAction_validateNoInputPins(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptEventAction_validateNoOutputPins(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptEventAction_validateTriggerEvents(
				acceptEventAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptEventAction_validateUnmarshallSignalEvents(
				acceptEventAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoInputPins constraint of '<em>Accept Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptEventAction_validateNoInputPins(
			AcceptEventAction acceptEventAction, DiagnosticChain diagnostics,
			Map context) {
		return acceptEventAction.validateNoInputPins(diagnostics, context);
	}

	/**
	 * Validates the validateNoOutputPins constraint of '<em>Accept Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptEventAction_validateNoOutputPins(
			AcceptEventAction acceptEventAction, DiagnosticChain diagnostics,
			Map context) {
		return acceptEventAction.validateNoOutputPins(diagnostics, context);
	}

	/**
	 * Validates the validateTriggerEvents constraint of '<em>Accept Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptEventAction_validateTriggerEvents(
			AcceptEventAction acceptEventAction, DiagnosticChain diagnostics,
			Map context) {
		return acceptEventAction.validateTriggerEvents(diagnostics, context);
	}

	/**
	 * Validates the validateUnmarshallSignalEvents constraint of '<em>Accept Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptEventAction_validateUnmarshallSignalEvents(
			AcceptEventAction acceptEventAction, DiagnosticChain diagnostics,
			Map context) {
		return acceptEventAction.validateUnmarshallSignalEvents(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptCallAction(AcceptCallAction acceptCallAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(acceptCallAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(acceptCallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(acceptCallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(acceptCallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(acceptCallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(acceptCallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(acceptCallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptEventAction_validateNoInputPins(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptEventAction_validateNoOutputPins(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptEventAction_validateTriggerEvents(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptEventAction_validateUnmarshallSignalEvents(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptCallAction_validateResultPins(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptCallAction_validateTriggerCallEvent(
				acceptCallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAcceptCallAction_validateUnmarshall(
				acceptCallAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateResultPins constraint of '<em>Accept Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptCallAction_validateResultPins(
			AcceptCallAction acceptCallAction, DiagnosticChain diagnostics,
			Map context) {
		return acceptCallAction.validateResultPins(diagnostics, context);
	}

	/**
	 * Validates the validateTriggerCallEvent constraint of '<em>Accept Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptCallAction_validateTriggerCallEvent(
			AcceptCallAction acceptCallAction, DiagnosticChain diagnostics,
			Map context) {
		return acceptCallAction.validateTriggerCallEvent(diagnostics, context);
	}

	/**
	 * Validates the validateUnmarshall constraint of '<em>Accept Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAcceptCallAction_validateUnmarshall(
			AcceptCallAction acceptCallAction, DiagnosticChain diagnostics,
			Map context) {
		return acceptCallAction.validateUnmarshall(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReplyAction(ReplyAction replyAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(replyAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(replyAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(replyAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(replyAction, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(replyAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(replyAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				replyAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				replyAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				replyAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				replyAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				replyAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(replyAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				replyAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReplyAction_validatePinsMatchParameter(
				replyAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateReplyAction_validateEventOnReplyToCallTrigger(
				replyAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validatePinsMatchParameter constraint of '<em>Reply Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReplyAction_validatePinsMatchParameter(
			ReplyAction replyAction, DiagnosticChain diagnostics, Map context) {
		return replyAction.validatePinsMatchParameter(diagnostics, context);
	}

	/**
	 * Validates the validateEventOnReplyToCallTrigger constraint of '<em>Reply Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReplyAction_validateEventOnReplyToCallTrigger(
			ReplyAction replyAction, DiagnosticChain diagnostics, Map context) {
		return replyAction.validateEventOnReplyToCallTrigger(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnmarshallAction(UnmarshallAction unmarshallAction,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(unmarshallAction,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(unmarshallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(unmarshallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(unmarshallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(unmarshallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(unmarshallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(unmarshallAction,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUnmarshallAction_validateSameType(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUnmarshallAction_validateMultiplicityOfObject(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUnmarshallAction_validateNumberOfResult(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUnmarshallAction_validateTypeAndOrdering(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUnmarshallAction_validateMultiplicityOfResult(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUnmarshallAction_validateStructuralFeature(
				unmarshallAction, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateUnmarshallAction_validateUnmarshallTypeIsClassifier(
				unmarshallAction, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateSameType constraint of '<em>Unmarshall Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnmarshallAction_validateSameType(
			UnmarshallAction unmarshallAction, DiagnosticChain diagnostics,
			Map context) {
		return unmarshallAction.validateSameType(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicityOfObject constraint of '<em>Unmarshall Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnmarshallAction_validateMultiplicityOfObject(
			UnmarshallAction unmarshallAction, DiagnosticChain diagnostics,
			Map context) {
		return unmarshallAction.validateMultiplicityOfObject(diagnostics,
			context);
	}

	/**
	 * Validates the validateNumberOfResult constraint of '<em>Unmarshall Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnmarshallAction_validateNumberOfResult(
			UnmarshallAction unmarshallAction, DiagnosticChain diagnostics,
			Map context) {
		return unmarshallAction.validateNumberOfResult(diagnostics, context);
	}

	/**
	 * Validates the validateTypeAndOrdering constraint of '<em>Unmarshall Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnmarshallAction_validateTypeAndOrdering(
			UnmarshallAction unmarshallAction, DiagnosticChain diagnostics,
			Map context) {
		return unmarshallAction.validateTypeAndOrdering(diagnostics, context);
	}

	/**
	 * Validates the validateMultiplicityOfResult constraint of '<em>Unmarshall Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnmarshallAction_validateMultiplicityOfResult(
			UnmarshallAction unmarshallAction, DiagnosticChain diagnostics,
			Map context) {
		return unmarshallAction.validateMultiplicityOfResult(diagnostics,
			context);
	}

	/**
	 * Validates the validateStructuralFeature constraint of '<em>Unmarshall Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnmarshallAction_validateStructuralFeature(
			UnmarshallAction unmarshallAction, DiagnosticChain diagnostics,
			Map context) {
		return unmarshallAction.validateStructuralFeature(diagnostics, context);
	}

	/**
	 * Validates the validateUnmarshallTypeIsClassifier constraint of '<em>Unmarshall Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnmarshallAction_validateUnmarshallTypeIsClassifier(
			UnmarshallAction unmarshallAction, DiagnosticChain diagnostics,
			Map context) {
		return unmarshallAction.validateUnmarshallTypeIsClassifier(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControlNode(ControlNode controlNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(controlNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(controlNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(controlNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(controlNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(controlNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(controlNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				controlNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				controlNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				controlNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				controlNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				controlNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(controlNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				controlNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControlFlow(ControlFlow controlFlow,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(controlFlow,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(controlFlow, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(controlFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(controlFlow, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(controlFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(controlFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				controlFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				controlFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				controlFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				controlFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				controlFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateSourceAndTarget(controlFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateOwned(controlFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateStructuredNode(controlFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateControlFlow_validateObjectNodes(controlFlow,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateObjectNodes constraint of '<em>Control Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControlFlow_validateObjectNodes(
			ControlFlow controlFlow, DiagnosticChain diagnostics, Map context) {
		return controlFlow.validateObjectNodes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInitialNode(InitialNode initialNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(initialNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(initialNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(initialNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(initialNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(initialNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(initialNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				initialNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				initialNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				initialNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				initialNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				initialNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(initialNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				initialNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInitialNode_validateNoIncomingEdges(initialNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateInitialNode_validateControlEdges(initialNode,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoIncomingEdges constraint of '<em>Initial Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInitialNode_validateNoIncomingEdges(
			InitialNode initialNode, DiagnosticChain diagnostics, Map context) {
		return initialNode.validateNoIncomingEdges(diagnostics, context);
	}

	/**
	 * Validates the validateControlEdges constraint of '<em>Initial Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInitialNode_validateControlEdges(
			InitialNode initialNode, DiagnosticChain diagnostics, Map context) {
		return initialNode.validateControlEdges(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityParameterNode(
			ActivityParameterNode activityParameterNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(activityParameterNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(activityParameterNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(activityParameterNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(activityParameterNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(activityParameterNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(activityParameterNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityParameterNode_validateHasParameters(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityParameterNode_validateSameType(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityParameterNode_validateNoEdges(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityParameterNode_validateNoIncomingEdges(
				activityParameterNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityParameterNode_validateNoOutgoingEdges(
				activityParameterNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateHasParameters constraint of '<em>Activity Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityParameterNode_validateHasParameters(
			ActivityParameterNode activityParameterNode,
			DiagnosticChain diagnostics, Map context) {
		return activityParameterNode
			.validateHasParameters(diagnostics, context);
	}

	/**
	 * Validates the validateSameType constraint of '<em>Activity Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityParameterNode_validateSameType(
			ActivityParameterNode activityParameterNode,
			DiagnosticChain diagnostics, Map context) {
		return activityParameterNode.validateSameType(diagnostics, context);
	}

	/**
	 * Validates the validateNoEdges constraint of '<em>Activity Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityParameterNode_validateNoEdges(
			ActivityParameterNode activityParameterNode,
			DiagnosticChain diagnostics, Map context) {
		return activityParameterNode.validateNoEdges(diagnostics, context);
	}

	/**
	 * Validates the validateNoIncomingEdges constraint of '<em>Activity Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityParameterNode_validateNoIncomingEdges(
			ActivityParameterNode activityParameterNode,
			DiagnosticChain diagnostics, Map context) {
		return activityParameterNode.validateNoIncomingEdges(diagnostics,
			context);
	}

	/**
	 * Validates the validateNoOutgoingEdges constraint of '<em>Activity Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityParameterNode_validateNoOutgoingEdges(
			ActivityParameterNode activityParameterNode,
			DiagnosticChain diagnostics, Map context) {
		return activityParameterNode.validateNoOutgoingEdges(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForkNode(ForkNode forkNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(forkNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(forkNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(forkNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(forkNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(forkNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(forkNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(forkNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(forkNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				forkNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				forkNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				forkNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(forkNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				forkNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateForkNode_validateOneIncomingEdge(forkNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateForkNode_validateEdges(forkNode, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validateOneIncomingEdge constraint of '<em>Fork Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForkNode_validateOneIncomingEdge(ForkNode forkNode,
			DiagnosticChain diagnostics, Map context) {
		return forkNode.validateOneIncomingEdge(diagnostics, context);
	}

	/**
	 * Validates the validateEdges constraint of '<em>Fork Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateForkNode_validateEdges(ForkNode forkNode,
			DiagnosticChain diagnostics, Map context) {
		return forkNode.validateEdges(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowFinalNode(FlowFinalNode flowFinalNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(flowFinalNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(flowFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(flowFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(flowFinalNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(flowFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(flowFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				flowFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				flowFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				flowFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				flowFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				flowFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(flowFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				flowFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalNode_validateNoOutgoingEdges(flowFinalNode,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalNode(FinalNode finalNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(finalNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(finalNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(finalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(finalNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(finalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(finalNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				finalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(finalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				finalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				finalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				finalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(finalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				finalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalNode_validateNoOutgoingEdges(finalNode,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoOutgoingEdges constraint of '<em>Final Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalNode_validateNoOutgoingEdges(
			FinalNode finalNode, DiagnosticChain diagnostics, Map context) {
		return finalNode.validateNoOutgoingEdges(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCentralBufferNode(
			CentralBufferNode centralBufferNode, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(centralBufferNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(centralBufferNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(centralBufferNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(centralBufferNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(centralBufferNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(centralBufferNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				centralBufferNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				centralBufferNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				centralBufferNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				centralBufferNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				centralBufferNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(centralBufferNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				centralBufferNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(
				centralBufferNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(centralBufferNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(
				centralBufferNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(
				centralBufferNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMergeNode(MergeNode mergeNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(mergeNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(mergeNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(mergeNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(mergeNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(mergeNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(mergeNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				mergeNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(mergeNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				mergeNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				mergeNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				mergeNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(mergeNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				mergeNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMergeNode_validateOneOutgoingEdge(mergeNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateMergeNode_validateEdges(mergeNode, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validateOneOutgoingEdge constraint of '<em>Merge Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMergeNode_validateOneOutgoingEdge(
			MergeNode mergeNode, DiagnosticChain diagnostics, Map context) {
		return mergeNode.validateOneOutgoingEdge(diagnostics, context);
	}

	/**
	 * Validates the validateEdges constraint of '<em>Merge Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMergeNode_validateEdges(MergeNode mergeNode,
			DiagnosticChain diagnostics, Map context) {
		return mergeNode.validateEdges(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecisionNode(DecisionNode decisionNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(decisionNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(decisionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(decisionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(decisionNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(decisionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(decisionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				decisionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				decisionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				decisionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				decisionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				decisionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(decisionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				decisionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDecisionNode_validateOneIncomingEdge(
				decisionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDecisionNode_validateInputParameter(decisionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateDecisionNode_validateEdges(decisionNode,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOneIncomingEdge constraint of '<em>Decision Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecisionNode_validateOneIncomingEdge(
			DecisionNode decisionNode, DiagnosticChain diagnostics, Map context) {
		return decisionNode.validateOneIncomingEdge(diagnostics, context);
	}

	/**
	 * Validates the validateInputParameter constraint of '<em>Decision Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecisionNode_validateInputParameter(
			DecisionNode decisionNode, DiagnosticChain diagnostics, Map context) {
		return decisionNode.validateInputParameter(diagnostics, context);
	}

	/**
	 * Validates the validateEdges constraint of '<em>Decision Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDecisionNode_validateEdges(
			DecisionNode decisionNode, DiagnosticChain diagnostics, Map context) {
		return decisionNode.validateEdges(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActivityFinalNode(
			ActivityFinalNode activityFinalNode, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(activityFinalNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(activityFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(activityFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(activityFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(activityFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(activityFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				activityFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				activityFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				activityFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				activityFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				activityFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(activityFinalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				activityFinalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalNode_validateNoOutgoingEdges(
				activityFinalNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJoinNode(JoinNode joinNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(joinNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(joinNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(joinNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(joinNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(joinNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(joinNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(joinNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(joinNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				joinNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				joinNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				joinNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(joinNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				joinNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateJoinNode_validateOneOutgoingEdge(joinNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateJoinNode_validateIncomingObjectFlow(joinNode,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOneOutgoingEdge constraint of '<em>Join Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJoinNode_validateOneOutgoingEdge(JoinNode joinNode,
			DiagnosticChain diagnostics, Map context) {
		return joinNode.validateOneOutgoingEdge(diagnostics, context);
	}

	/**
	 * Validates the validateIncomingObjectFlow constraint of '<em>Join Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJoinNode_validateIncomingObjectFlow(
			JoinNode joinNode, DiagnosticChain diagnostics, Map context) {
		return joinNode.validateIncomingObjectFlow(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataStoreNode(DataStoreNode dataStoreNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(dataStoreNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(dataStoreNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(dataStoreNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(dataStoreNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(dataStoreNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(dataStoreNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				dataStoreNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				dataStoreNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				dataStoreNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				dataStoreNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				dataStoreNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(dataStoreNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				dataStoreNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(dataStoreNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(dataStoreNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(
				dataStoreNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(
				dataStoreNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow(ObjectFlow objectFlow,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(objectFlow,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(objectFlow, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(objectFlow, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(objectFlow, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				objectFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				objectFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				objectFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				objectFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateSourceAndTarget(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateOwned(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityEdge_validateStructuredNode(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectFlow_validateNoActions(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectFlow_validateCompatibleTypes(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectFlow_validateSameUpperBounds(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectFlow_validateTarget(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectFlow_validateTransformationBehaviour(
				objectFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectFlow_validateSelectionBehaviour(objectFlow,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectFlow_validateInputAndOutputParameter(
				objectFlow, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectFlow_validateIsMulticastOrIsMultireceive(
				objectFlow, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoActions constraint of '<em>Object Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow_validateNoActions(ObjectFlow objectFlow,
			DiagnosticChain diagnostics, Map context) {
		return objectFlow.validateNoActions(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypes constraint of '<em>Object Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow_validateCompatibleTypes(
			ObjectFlow objectFlow, DiagnosticChain diagnostics, Map context) {
		return objectFlow.validateCompatibleTypes(diagnostics, context);
	}

	/**
	 * Validates the validateSameUpperBounds constraint of '<em>Object Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow_validateSameUpperBounds(
			ObjectFlow objectFlow, DiagnosticChain diagnostics, Map context) {
		return objectFlow.validateSameUpperBounds(diagnostics, context);
	}

	/**
	 * Validates the validateTarget constraint of '<em>Object Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow_validateTarget(ObjectFlow objectFlow,
			DiagnosticChain diagnostics, Map context) {
		return objectFlow.validateTarget(diagnostics, context);
	}

	/**
	 * Validates the validateTransformationBehaviour constraint of '<em>Object Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow_validateTransformationBehaviour(
			ObjectFlow objectFlow, DiagnosticChain diagnostics, Map context) {
		return objectFlow.validateTransformationBehaviour(diagnostics, context);
	}

	/**
	 * Validates the validateSelectionBehaviour constraint of '<em>Object Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow_validateSelectionBehaviour(
			ObjectFlow objectFlow, DiagnosticChain diagnostics, Map context) {
		return objectFlow.validateSelectionBehaviour(diagnostics, context);
	}

	/**
	 * Validates the validateInputAndOutputParameter constraint of '<em>Object Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow_validateInputAndOutputParameter(
			ObjectFlow objectFlow, DiagnosticChain diagnostics, Map context) {
		return objectFlow.validateInputAndOutputParameter(diagnostics, context);
	}

	/**
	 * Validates the validateIsMulticastOrIsMultireceive constraint of '<em>Object Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectFlow_validateIsMulticastOrIsMultireceive(
			ObjectFlow objectFlow, DiagnosticChain diagnostics, Map context) {
		return objectFlow.validateIsMulticastOrIsMultireceive(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceNode(SequenceNode sequenceNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(sequenceNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(sequenceNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(sequenceNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(sequenceNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(sequenceNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(sequenceNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				sequenceNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				sequenceNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				sequenceNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				sequenceNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				sequenceNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(sequenceNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				sequenceNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				sequenceNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNodesAndEdges(sequenceNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNotContained(sequenceNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateGroupOwned(sequenceNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredActivityNode_validateEdges(
				sequenceNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalNode(ConditionalNode conditionalNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(conditionalNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(conditionalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(conditionalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(conditionalNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(conditionalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(conditionalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(conditionalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNodesAndEdges(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNotContained(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateGroupOwned(conditionalNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredActivityNode_validateEdges(
				conditionalNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateConditionalNode_validateResultNoIncoming(
				conditionalNode, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateResultNoIncoming constraint of '<em>Conditional Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalNode_validateResultNoIncoming(
			ConditionalNode conditionalNode, DiagnosticChain diagnostics,
			Map context) {
		return conditionalNode.validateResultNoIncoming(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClause(Clause clause, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(clause,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(clause, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(clause, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(clause, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(clause, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(clause, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateClause_validateDeciderOutput(clause, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateClause_validateBodyOutputPins(clause,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDeciderOutput constraint of '<em>Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClause_validateDeciderOutput(Clause clause,
			DiagnosticChain diagnostics, Map context) {
		return clause.validateDeciderOutput(diagnostics, context);
	}

	/**
	 * Validates the validateBodyOutputPins constraint of '<em>Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClause_validateBodyOutputPins(Clause clause,
			DiagnosticChain diagnostics, Map context) {
		return clause.validateBodyOutputPins(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopNode(LoopNode loopNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(loopNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(loopNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(loopNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(loopNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(loopNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(loopNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(loopNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(loopNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				loopNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				loopNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				loopNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(loopNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				loopNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				loopNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNodesAndEdges(loopNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNotContained(loopNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateGroupOwned(loopNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredActivityNode_validateEdges(loopNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLoopNode_validateInputEdges(loopNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLoopNode_validateBodyOutputPins(loopNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateLoopNode_validateResultNoIncoming(loopNode,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateInputEdges constraint of '<em>Loop Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopNode_validateInputEdges(LoopNode loopNode,
			DiagnosticChain diagnostics, Map context) {
		return loopNode.validateInputEdges(diagnostics, context);
	}

	/**
	 * Validates the validateBodyOutputPins constraint of '<em>Loop Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopNode_validateBodyOutputPins(LoopNode loopNode,
			DiagnosticChain diagnostics, Map context) {
		return loopNode.validateBodyOutputPins(diagnostics, context);
	}

	/**
	 * Validates the validateResultNoIncoming constraint of '<em>Loop Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopNode_validateResultNoIncoming(LoopNode loopNode,
			DiagnosticChain diagnostics, Map context) {
		return loopNode.validateResultNoIncoming(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpansionNode(ExpansionNode expansionNode,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(expansionNode,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(expansionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(expansionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(expansionNode, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(expansionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(expansionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				expansionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				expansionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				expansionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				expansionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				expansionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(expansionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				expansionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateObjectFlowEdges(expansionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateNotUnique(expansionNode,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateSelectionBehavior(
				expansionNode, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateObjectNode_validateInputOutputParameter(
				expansionNode, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpansionRegion(ExpansionRegion expansionRegion,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(expansionRegion,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(expansionRegion,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(expansionRegion,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(expansionRegion, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(expansionRegion,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(expansionRegion,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwned(expansionRegion,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityNode_validateOwnedStructuredNode(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNodesAndEdges(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateNotContained(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateActivityGroup_validateGroupOwned(expansionRegion,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredActivityNode_validateEdges(
				expansionRegion, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateExpansionRegion_validateExpansionNodes(
				expansionRegion, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateExpansionNodes constraint of '<em>Expansion Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpansionRegion_validateExpansionNodes(
			ExpansionRegion expansionRegion, DiagnosticChain diagnostics,
			Map context) {
		return expansionRegion.validateExpansionNodes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponentRealization(
			ComponentRealization componentRealization,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			componentRealization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(componentRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(componentRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(componentRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(componentRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(componentRealization,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				componentRealization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				componentRealization, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				componentRealization, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponent(Component component,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(component,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(component, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(component,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(component, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(component,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(component, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(component,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(component,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				component, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(component,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNode(Node node, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(node, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(node, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(node, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(node, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(node, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(node, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(node,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(node,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				node, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(node,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				node, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				node, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(node,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				node, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(node,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(node,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(node,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(node,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(node, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNode_validateInternalStructure(node, diagnostics,
				context);
		return result;
	}

	/**
	 * Validates the validateInternalStructure constraint of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNode_validateInternalStructure(Node node,
			DiagnosticChain diagnostics, Map context) {
		return node.validateInternalStructure(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDevice(Device device, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(device,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(device, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(device, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(device, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(device, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(device,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(device,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(device,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(device,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				device, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(device, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNode_validateInternalStructure(device,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExecutionEnvironment(
			ExecutionEnvironment executionEnvironment,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(
			executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(executionEnvironment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(executionEnvironment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(executionEnvironment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(executionEnvironment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(executionEnvironment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				executionEnvironment, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(executionEnvironment,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNode_validateInternalStructure(
				executionEnvironment, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommunicationPath(
			CommunicationPath communicationPath, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(communicationPath,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(communicationPath,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(communicationPath,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(communicationPath,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(communicationPath,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(communicationPath,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateSpecializedEndNumber(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateSpecializedEndTypes(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateBinaryAssociations(
				communicationPath, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCommunicationPath_validateAssociationEnds(
				communicationPath, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateAssociationEnds constraint of '<em>Communication Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommunicationPath_validateAssociationEnds(
			CommunicationPath communicationPath, DiagnosticChain diagnostics,
			Map context) {
		// TODO override the constraint, if desired
		// -> uncomment the scaffolding
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericConstraint_diagnostic", new Object[]{"validateAssociationEnds", getObjectLabel(communicationPath, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{communicationPath}));
			}
			return false;
		}
		return validateAssociation_validateAssociationEnds(communicationPath,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState(FinalState finalState,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(finalState,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(finalState, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(finalState, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(finalState, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				finalState, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				finalState, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				finalState, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				finalState, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				finalState, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateRegions(finalState, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateState_validateSubmachineStates(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateDestinationsOrSourcesOfTransitions(
				finalState, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateSubmachineOrRegions(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateCompositeStates(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateState_validateEntryOrExit(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalState_validateNoOutgoingTransitions(
				finalState, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalState_validateNoRegions(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalState_validateCannotReferenceSubmachine(
				finalState, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalState_validateNoEntryBehavior(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalState_validateNoExitbehavior(finalState,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateFinalState_validateNoStateBehavior(finalState,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNoOutgoingTransitions constraint of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState_validateNoOutgoingTransitions(
			FinalState finalState, DiagnosticChain diagnostics, Map context) {
		return finalState.validateNoOutgoingTransitions(diagnostics, context);
	}

	/**
	 * Validates the validateNoRegions constraint of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState_validateNoRegions(FinalState finalState,
			DiagnosticChain diagnostics, Map context) {
		return finalState.validateNoRegions(diagnostics, context);
	}

	/**
	 * Validates the validateCannotReferenceSubmachine constraint of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState_validateCannotReferenceSubmachine(
			FinalState finalState, DiagnosticChain diagnostics, Map context) {
		return finalState.validateCannotReferenceSubmachine(diagnostics,
			context);
	}

	/**
	 * Validates the validateNoEntryBehavior constraint of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState_validateNoEntryBehavior(
			FinalState finalState, DiagnosticChain diagnostics, Map context) {
		return finalState.validateNoEntryBehavior(diagnostics, context);
	}

	/**
	 * Validates the validateNoExitbehavior constraint of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState_validateNoExitbehavior(
			FinalState finalState, DiagnosticChain diagnostics, Map context) {
		return finalState.validateNoExitbehavior(diagnostics, context);
	}

	/**
	 * Validates the validateNoStateBehavior constraint of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState_validateNoStateBehavior(
			FinalState finalState, DiagnosticChain diagnostics, Map context) {
		return finalState.validateNoStateBehavior(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeEvent(TimeEvent timeEvent,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(timeEvent,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(timeEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(timeEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(timeEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(timeEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(timeEvent, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				timeEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(timeEvent,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				timeEvent, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTimeEvent_validateStartingTime(timeEvent,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateStartingTime constraint of '<em>Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimeEvent_validateStartingTime(TimeEvent timeEvent,
			DiagnosticChain diagnostics, Map context) {
		return timeEvent.validateStartingTime(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolTransition(
			ProtocolTransition protocolTransition, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validate_EveryMultiplicityConforms(protocolTransition,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(protocolTransition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(protocolTransition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(protocolTransition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(protocolTransition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(protocolTransition,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateForkSegmentGuards(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateJoinSegmentGuards(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateForkSegmentState(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateJoinSegmentState(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateOutgoingPseudostates(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateInitialTransition(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransition_validateSignaturesCompatible(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProtocolTransition_validateBelongsPsm(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProtocolTransition_validateAssociatedActions(
				protocolTransition, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateProtocolTransition_validateRefersToOperation(
				protocolTransition, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateBelongsPsm constraint of '<em>Protocol Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolTransition_validateBelongsPsm(
			ProtocolTransition protocolTransition, DiagnosticChain diagnostics,
			Map context) {
		return protocolTransition.validateBelongsPsm(diagnostics, context);
	}

	/**
	 * Validates the validateAssociatedActions constraint of '<em>Protocol Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolTransition_validateAssociatedActions(
			ProtocolTransition protocolTransition, DiagnosticChain diagnostics,
			Map context) {
		return protocolTransition.validateAssociatedActions(diagnostics,
			context);
	}

	/**
	 * Validates the validateRefersToOperation constraint of '<em>Protocol Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtocolTransition_validateRefersToOperation(
			ProtocolTransition protocolTransition, DiagnosticChain diagnostics,
			Map context) {
		return protocolTransition.validateRefersToOperation(diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClass(AssociationClass associationClass,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(associationClass,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(associationClass,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(associationClass,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(associationClass,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateNotOwnSelf(associationClass,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateElement_validateHasOwner(associationClass,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasNoQualifiedName(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateHasQualifiedName(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamedElement_validateVisibilityNeedsOwnership(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateNamespace_validateMembersDistinguishable(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionContextValid(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateRedefinableElement_validateRedefinitionConsistent(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateNoCyclesInGeneralization(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateGeneralizationHierarchies(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateSpecializeType(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClassifier_validateMapsToGeneralizationSet(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateStructuredClassifier_validateMultiplicities(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateBehavioredClassifier_validateClassBehavior(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateClass_validatePassiveClass(associationClass,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateSpecializedEndNumber(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateSpecializedEndTypes(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateBinaryAssociations(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociation_validateAssociationEnds(
				associationClass, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateAssociationClass_validateCannotBeDefined(
				associationClass, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCannotBeDefined constraint of '<em>Association Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClass_validateCannotBeDefined(
			AssociationClass associationClass, DiagnosticChain diagnostics,
			Map context) {
		return associationClass.validateCannotBeDefined(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisibilityKind(Object visibilityKind,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallConcurrencyKind(Object callConcurrencyKind,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransitionKind(Object transitionKind,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validateTransitionKind_state_is_local(transitionKind,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validateTransitionKind_state_is_external(transitionKind,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the state_is_local constraint of '<em>Transition Kind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransitionKind_state_is_local(Object transitionKind,
			DiagnosticChain diagnostics, Map context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericConstraint_diagnostic", new Object[]{"state_is_local", getValueLabel(UMLPackage.Literals.TRANSITION_KIND, transitionKind, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transitionKind}));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the state_is_external constraint of '<em>Transition Kind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransitionKind_state_is_external(
			Object transitionKind, DiagnosticChain diagnostics, Map context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericConstraint_diagnostic", new Object[]{"state_is_external", getValueLabel(UMLPackage.Literals.TRANSITION_KIND, transitionKind, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{transitionKind}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostateKind(Object pseudostateKind,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAggregationKind(Object aggregationKind,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterDirectionKind(
			Object parameterDirectionKind, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterEffectKind(Object parameterEffectKind,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectorKind(Object connectorKind,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageKind(Object messageKind,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageSort(Object messageSort,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectNodeOrderingKind(
			Object objectNodeOrderingKind, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteractionOperatorKind(
			Object interactionOperatorKind, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpansionKind(Object expansionKind,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

} //UMLValidator