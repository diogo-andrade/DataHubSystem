// Generated from wcps.g4 by ANTLR 4.1
package petascope.wcps2.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link wcpsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface wcpsVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link wcpsParser#FieldInterpolationListLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFieldInterpolationListLabel(@NotNull wcpsParser.FieldInterpolationListLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionOverlayLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionOverlayLabel(@NotNull wcpsParser.CoverageExpressionOverlayLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#AxisSpecLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAxisSpecLabel(@NotNull wcpsParser.AxisSpecLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionTrigonometricLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionTrigonometricLabel(@NotNull wcpsParser.CoverageExpressionTrigonometricLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#FieldInterpolationListElementLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFieldInterpolationListElementLabel(@NotNull wcpsParser.FieldInterpolationListElementLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#coverageArithmeticOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageArithmeticOperator(@NotNull wcpsParser.CoverageArithmeticOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#booleanOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanOperator(@NotNull wcpsParser.BooleanOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#exponentialExpressionOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExponentialExpressionOperator(@NotNull wcpsParser.ExponentialExpressionOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionConstantLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionConstantLabel(@NotNull wcpsParser.CoverageExpressionConstantLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageConstantExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageConstantExpressionLabel(@NotNull wcpsParser.CoverageConstantExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#stringOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStringOperator(@NotNull wcpsParser.StringOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CastExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCastExpressionLabel(@NotNull wcpsParser.CastExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#InterpolationTypeLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInterpolationTypeLabel(@NotNull wcpsParser.InterpolationTypeLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionComparissonLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionComparissonLabel(@NotNull wcpsParser.CoverageExpressionComparissonLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#BitUnaryBooleanExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBitUnaryBooleanExpressionLabel(@NotNull wcpsParser.BitUnaryBooleanExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionScaleLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionScaleLabel(@NotNull wcpsParser.CoverageExpressionScaleLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#fieldName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFieldName(@NotNull wcpsParser.FieldNameContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#SliceDimensionIntervalElementLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSliceDimensionIntervalElementLabel(@NotNull wcpsParser.SliceDimensionIntervalElementLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#nullResistance}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNullResistance(@NotNull wcpsParser.NullResistanceContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#BooleanNumericalComparisonScalarLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanNumericalComparisonScalarLabel(@NotNull wcpsParser.BooleanNumericalComparisonScalarLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#booleanConstant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanConstant(@NotNull wcpsParser.BooleanConstantContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#numericalUnaryOperation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalUnaryOperation(@NotNull wcpsParser.NumericalUnaryOperationContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#processingExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProcessingExpression(@NotNull wcpsParser.ProcessingExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionRangeSubsettingLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionRangeSubsettingLabel(@NotNull wcpsParser.CoverageExpressionRangeSubsettingLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#TrigonometricExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTrigonometricExpressionLabel(@NotNull wcpsParser.TrigonometricExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#reduceExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReduceExpression(@NotNull wcpsParser.ReduceExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#BooleanReduceExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanReduceExpression(@NotNull wcpsParser.BooleanReduceExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#numericalOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalOperator(@NotNull wcpsParser.NumericalOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#NumericalCondenseExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalCondenseExpressionLabel(@NotNull wcpsParser.NumericalCondenseExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#StringScalarExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStringScalarExpressionLabel(@NotNull wcpsParser.StringScalarExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#trigonometricOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTrigonometricOperator(@NotNull wcpsParser.TrigonometricOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionSliceLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionSliceLabel(@NotNull wcpsParser.CoverageExpressionSliceLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#BooleanConstantLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanConstantLabel(@NotNull wcpsParser.BooleanConstantLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#DimensionCrsElementLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDimensionCrsElementLabel(@NotNull wcpsParser.DimensionCrsElementLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionArithmeticLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionArithmeticLabel(@NotNull wcpsParser.CoverageExpressionArithmeticLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionDecodeLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionDecodeLabel(@NotNull wcpsParser.CoverageExpressionDecodeLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#rangeType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRangeType(@NotNull wcpsParser.RangeTypeContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionScalarLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionScalarLabel(@NotNull wcpsParser.CoverageExpressionScalarLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#AxisIteratorLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAxisIteratorLabel(@NotNull wcpsParser.AxisIteratorLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#ReduceNumericalExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReduceNumericalExpressionLabel(@NotNull wcpsParser.ReduceNumericalExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#RangeConstructorExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRangeConstructorExpressionLabel(@NotNull wcpsParser.RangeConstructorExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#axisName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAxisName(@NotNull wcpsParser.AxisNameContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#DecodedCoverageExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDecodedCoverageExpressionLabel(@NotNull wcpsParser.DecodedCoverageExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionShorthandSliceLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionShorthandSliceLabel(@NotNull wcpsParser.CoverageExpressionShorthandSliceLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageVariableNameLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageVariableNameLabel(@NotNull wcpsParser.CoverageVariableNameLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#NumericalUnaryScalarExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalUnaryScalarExpressionLabel(@NotNull wcpsParser.NumericalUnaryScalarExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionShorthandTrimLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionShorthandTrimLabel(@NotNull wcpsParser.CoverageExpressionShorthandTrimLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#crsName}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCrsName(@NotNull wcpsParser.CrsNameContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#BooleanStringComparisonScalar}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanStringComparisonScalar(@NotNull wcpsParser.BooleanStringComparisonScalarContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionExponentialLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionExponentialLabel(@NotNull wcpsParser.CoverageExpressionExponentialLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#ReturnClauseLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReturnClauseLabel(@NotNull wcpsParser.ReturnClauseLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#IntervalExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIntervalExpressionLabel(@NotNull wcpsParser.IntervalExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#NumericalTrigonometricScalarExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalTrigonometricScalarExpressionLabel(@NotNull wcpsParser.NumericalTrigonometricScalarExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#NumericalRealNumberExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalRealNumberExpressionLabel(@NotNull wcpsParser.NumericalRealNumberExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#DimensionCrsListLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDimensionCrsListLabel(@NotNull wcpsParser.DimensionCrsListLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#ForClauseListLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForClauseListLabel(@NotNull wcpsParser.ForClauseListLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#ForClauseLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForClauseLabel(@NotNull wcpsParser.ForClauseLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionUnaryBooleanLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionUnaryBooleanLabel(@NotNull wcpsParser.CoverageExpressionUnaryBooleanLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageConstructorExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageConstructorExpressionLabel(@NotNull wcpsParser.CoverageConstructorExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionUnaryArithmeticLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionUnaryArithmeticLabel(@NotNull wcpsParser.CoverageExpressionUnaryArithmeticLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionExtendLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionExtendLabel(@NotNull wcpsParser.CoverageExpressionExtendLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#NumericalComplexNumberConstant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalComplexNumberConstant(@NotNull wcpsParser.NumericalComplexNumberConstantContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#DescribeCoverageExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDescribeCoverageExpressionLabel(@NotNull wcpsParser.DescribeCoverageExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#NumericalBinaryScalarExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalBinaryScalarExpressionLabel(@NotNull wcpsParser.NumericalBinaryScalarExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionCoverageLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionCoverageLabel(@NotNull wcpsParser.CoverageExpressionCoverageLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#ComplexNumberConstantLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComplexNumberConstantLabel(@NotNull wcpsParser.ComplexNumberConstantLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#BooleanUnaryScalarLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanUnaryScalarLabel(@NotNull wcpsParser.BooleanUnaryScalarLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionConstructorLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionConstructorLabel(@NotNull wcpsParser.CoverageExpressionConstructorLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#UnaryCoverageArithmeticExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnaryCoverageArithmeticExpressionLabel(@NotNull wcpsParser.UnaryCoverageArithmeticExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#NotUnaryBooleanExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNotUnaryBooleanExpressionLabel(@NotNull wcpsParser.NotUnaryBooleanExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#InterpolationMethodLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInterpolationMethodLabel(@NotNull wcpsParser.InterpolationMethodLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionCrsTransformLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionCrsTransformLabel(@NotNull wcpsParser.CoverageExpressionCrsTransformLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#GeneralCondenseExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGeneralCondenseExpressionLabel(@NotNull wcpsParser.GeneralCondenseExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionCastLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionCastLabel(@NotNull wcpsParser.CoverageExpressionCastLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CrsTransformExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCrsTransformExpressionLabel(@NotNull wcpsParser.CrsTransformExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#EncodedCoverageExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEncodedCoverageExpressionLabel(@NotNull wcpsParser.EncodedCoverageExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#DimensionPointElementLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDimensionPointElementLabel(@NotNull wcpsParser.DimensionPointElementLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionTrimCoverageLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionTrimCoverageLabel(@NotNull wcpsParser.CoverageExpressionTrimCoverageLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#numericalComparissonOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumericalComparissonOperator(@NotNull wcpsParser.NumericalComparissonOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionLogicLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionLogicLabel(@NotNull wcpsParser.CoverageExpressionLogicLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#DimensionPointListLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDimensionPointListLabel(@NotNull wcpsParser.DimensionPointListLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageIdExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageIdExpressionLabel(@NotNull wcpsParser.CoverageIdExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#reduceNumericalExpressionOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReduceNumericalExpressionOperator(@NotNull wcpsParser.ReduceNumericalExpressionOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#BooleanBinaryScalarLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanBinaryScalarLabel(@NotNull wcpsParser.BooleanBinaryScalarLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#scalarExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitScalarExpression(@NotNull wcpsParser.ScalarExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionVariableNameLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionVariableNameLabel(@NotNull wcpsParser.CoverageExpressionVariableNameLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#TrimDimensionIntervalElementLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTrimDimensionIntervalElementLabel(@NotNull wcpsParser.TrimDimensionIntervalElementLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#condenseExpressionOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCondenseExpressionOperator(@NotNull wcpsParser.CondenseExpressionOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#unaryArithmeticExpressionOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnaryArithmeticExpressionOperator(@NotNull wcpsParser.UnaryArithmeticExpressionOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CRSIntervalExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCRSIntervalExpressionLabel(@NotNull wcpsParser.CRSIntervalExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#booleanUnaryOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBooleanUnaryOperator(@NotNull wcpsParser.BooleanUnaryOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#constant}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstant(@NotNull wcpsParser.ConstantContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#condenseExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCondenseExpression(@NotNull wcpsParser.CondenseExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#DimensionIntervalListLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDimensionIntervalListLabel(@NotNull wcpsParser.DimensionIntervalListLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#StarExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStarExpressionLabel(@NotNull wcpsParser.StarExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#getComponentExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGetComponentExpression(@NotNull wcpsParser.GetComponentExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#WcpsQueryLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWcpsQueryLabel(@NotNull wcpsParser.WcpsQueryLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#reduceBooleanExpressionOperator}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReduceBooleanExpressionOperator(@NotNull wcpsParser.ReduceBooleanExpressionOperatorContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#ReduceBooleanExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReduceBooleanExpressionLabel(@NotNull wcpsParser.ReduceBooleanExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#ExponentialExpressionLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExponentialExpressionLabel(@NotNull wcpsParser.ExponentialExpressionLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#WhereClauseLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhereClauseLabel(@NotNull wcpsParser.WhereClauseLabelContext ctx);

    /**
     * Visit a parse tree produced by {@link wcpsParser#CoverageExpressionRangeConstructorLabel}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCoverageExpressionRangeConstructorLabel(@NotNull wcpsParser.CoverageExpressionRangeConstructorLabelContext ctx);
}