/*
 * Copyright (C) 2017 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.opendatakit.tables.views.webkits;

import java.lang.ref.WeakReference;

/**
 * Created by jbeorse on 5/9/17.
 */

public class OdkTablesIf {

  public static final String TAG = "OdkTablesIf";

  private WeakReference<OdkTables> weakControl;

  OdkTablesIf(OdkTables odkTables) {
    weakControl = new WeakReference<OdkTables>(odkTables);
  }

  public boolean isInactive() {
    return (weakControl.get() == null) || weakControl.get().isInactive();
  }

  /**
   * Set list view portion of a DetailWithList view, restricted by given query.
   *
   * @param tableId       the tableId of the table to open
   * @param whereClause   If null will not restrict the results.
   * @param selectionArgs an array of selection arguments, one for each "?" in whereClause.
   *                      If null will not restrict the results.
   * @param relativePath  the name of the file specifying the list view, relative to the app
   *                      folder.
   * @return true if the open succeeded
   */
  @android.webkit.JavascriptInterface
  public boolean setSubListView(String tableId, String whereClause, String[] selectionArgs,
      String relativePath) {
    if (isInactive())
      return false;
    return weakControl.get()
        .helperSetSubListView(tableId, relativePath, whereClause, selectionArgs, null, null, null,
            null);
  }
}