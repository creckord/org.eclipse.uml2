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
 * $Id: Pseudostate.java,v 1.3 2005/11/28 20:26:01 khussey Exp $
 */
package org.eclipse.uml2.uml;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pseudostate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Pseudostates are typically used to connect multiple transitions into more complex state transitions paths. For example, by combining a transition entering a fork pseudostate with a set of transitions exiting the fork pseudostate, we get a compound transition that leads to a set of orthogonal target states.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Pseudostate#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Pseudostate#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Pseudostate#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getPseudostate()
 * @model
 * @generated
 */
public interface Pseudostate
		extends Vertex {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.uml2.uml.PseudostateKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines the precise type of the Pseudostate and can be one of: entryPoint, exitPoint, initial, deepHistory, shallowHistory, join, fork, junction, terminate or choice.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.uml2.uml.PseudostateKind
	 * @see #isSetKind()
	 * @see #unsetKind()
	 * @see #setKind(PseudostateKind)
	 * @see org.eclipse.uml2.uml.UMLPackage#getPseudostate_Kind()
	 * @model unsettable="true" required="true" ordered="false"
	 * @generated
	 */
	PseudostateKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Pseudostate#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.uml2.uml.PseudostateKind
	 * @see #isSetKind()
	 * @see #unsetKind()
	 * @see #getKind()
	 * @generated
	 */
	void setKind(PseudostateKind value);

	/**
	 * Unsets the value of the '{@link org.eclipse.uml2.uml.Pseudostate#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKind()
	 * @see #getKind()
	 * @see #setKind(PseudostateKind)
	 * @generated
	 */
	void unsetKind();

	/**
	 * Returns whether the value of the '{@link org.eclipse.uml2.uml.Pseudostate#getKind <em>Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kind</em>' attribute is set.
	 * @see #unsetKind()
	 * @see #getKind()
	 * @see #setKind(PseudostateKind)
	 * @generated
	 */
	boolean isSetKind();

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.StateMachine#getConnectionPoints <em>Connection Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The StateMachine in which this Pseudostate is defined. This only applies to Pseudostates of the kind entryPoint or exitPoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State Machine</em>' container reference.
	 * @see #setStateMachine(StateMachine)
	 * @see org.eclipse.uml2.uml.UMLPackage#getPseudostate_StateMachine()
	 * @see org.eclipse.uml2.uml.StateMachine#getConnectionPoints
	 * @model opposite="connectionPoint" resolveProxies="false" ordered="false"
	 * @generated
	 */
	StateMachine getStateMachine();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Pseudostate#getStateMachine <em>State Machine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' container reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachine value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.State#getConnectionPoints <em>Connection Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The State that owns the pseudostate. If a Pseudostat is owned by a State, then it cannot also be owned by a StateMachine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State</em>' container reference.
	 * @see #setState(State)
	 * @see org.eclipse.uml2.uml.UMLPackage#getPseudostate_State()
	 * @see org.eclipse.uml2.uml.State#getConnectionPoints
	 * @model opposite="connectionPoint" resolveProxies="false" ordered="false"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.Pseudostate#getState <em>State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' container reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An initial vertex can have at most one outgoing transition.
	 * (self.kind = #initial) implies (self.outgoing->size <= 1)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateInitialVertex(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * History vertices can have at most one outgoing transition.
	 * ((self.kind = #deepHistory) or (self.kind = #shallowHistory)) implies
	 * (self.outgoing->size <= 1)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateHistoryVertices(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In a complete statemachine, a join vertex must have at least two incoming transitions and exactly one outgoing transition.
	 * (self.kind = #join) implies
	 * ((self.outgoing->size = 1) and (self.incoming->size >= 2))
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateJoinVertex(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All transitions incoming a join vertex must originate in different regions of an orthogonal state.
	 * (self.kind = #join) implies
	 *   self.incoming->forAll (t1, t2 | t1<>t2 implies
	 *     (self.stateMachine.LCA(t1.source, t2.source).container.isOrthogonal))
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateTransitionsIncoming(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In a complete statemachine, a fork vertex must have at least two outgoing transitions and exactly one incoming transition.
	 * (self.kind = #fork) implies
	 * ((self.incoming->size = 1) and (self.outgoing->size >= 2))
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateForkVertex(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All transitions outgoing a fork vertex must target states in different regions of an orthogonal state.
	 * (self.kind = #fork) implies
	 *   self.outgoing->forAll (t1, t2 | t1<>t2 implies
	 *     (self.stateMachine.LCA(t1.target, t2.target).container.isOrthogonal))
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateTransitionsOutgoing(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In a complete statemachine, a junction vertex must have at least one incoming and one outgoing transition.
	 * (self.kind = #junction) implies
	 * ((self.incoming->size >= 1) and (self.outgoing->size >= 1))
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateJunctionVertex(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In a complete statemachine, a choice vertex must have at least one incoming and one outgoing transition.
	 * (self.kind = #choice) implies
	 * ((self.incoming->size >= 1) and (self.outgoing->size >= 1))
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateChoiceVertex(DiagnosticChain diagnostics, Map context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The outgoing transition from and initial vertex may have a behavior, but not a trigger or a guard.
	 * (self.kind = #initial) implies (self.outgoing.guard->isEmpty()
	 * 
	 *   and self.outgoing.trigger->isEmpty())
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateOutgoingFromInitial(DiagnosticChain diagnostics, Map context);

} // Pseudostate