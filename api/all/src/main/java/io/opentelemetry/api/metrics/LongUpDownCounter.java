/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.api.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import javax.annotation.concurrent.ThreadSafe;

/**
 * An UpDownCounter instrument that records {@code long} values.
 *
 * @since 1.10.0
 */
@ThreadSafe
public interface LongUpDownCounter {
  /**
   * Records a value.
   *
   * <p>Note: This may use {@code Context.current()} to pull the context associated with this
   * measurement.
   *
   * @param value The increment amount. May be positive, negative or zero.
   */
  void add(long value);

  /**
   * Record a value with a set of attributes.
   *
   * <p>Note: This may use {@code Context.current()} to pull the context associated with this
   * measurement.
   *
   * @param value The increment amount. May be positive, negative or zero.
   * @param attributes A set of attributes to associate with the value.
   */
  void add(long value, Attributes attributes);

  /**
   * Records a value with a set of attributes.
   *
   * @param value The increment amount. May be positive, negative or zero.
   * @param attributes A set of attributes to associate with the value.
   * @param context The explicit context to associate with this measurement.
   */
  void add(long value, Attributes attributes, Context context);

  /**
   * Remove the handle/measurement from the storage.
   *
   * @param attributes A set of attributes.
   */
  void remove(Attributes attributes);
}
