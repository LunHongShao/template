package other.mvvm.activity.res.layout

fun dialogXml(
) = """
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rootLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:ignore="MissingDefaultResource">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/contentLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginHorizontal="47dp"
        android:background="@drawable/shape_ffffff_rd10"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        
    </androidx.constraintlayout.widget.ConstraintLayout>

    <ImageView
        android:id="@+id/closeImage"
        android:layout_width="95dp"
        android:layout_height="74dp"
        android:src="@drawable/ic_close_group"
        app:layout_constraintBottom_toTopOf="@id/contentLayout"
        app:layout_constraintEnd_toEndOf="@id/contentLayout"
        app:layout_constraintTop_toTopOf="@id/contentLayout" />
</androidx.constraintlayout.widget.ConstraintLayout>"""