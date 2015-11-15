package de.schroedel.doyourstuff.content;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import de.schroedel.doyourstuff.R;

/**
 * Category type of a to do item.
 */
public enum Category
{
	// Default
	ITEM_DEFAULT(0x01),
	ITEM_IMPORTANT(0x02),

	// Goods
	ITEM_SHOPPING(0x11),
	ITEM_FOOD(0x12),

	// Social
	ITEM_GAMING(0x21),
	ITEM_PARTY(0x22),
	ITEM_PHONE(0x23),

	// Household
	ITEM_HOUSE(0x31),

	// Duty
	ITEM_SCHOOL(0x41),
	ITEM_WORK(0x42),

	// Fitness
	ITEM_SPORT(0x51),

	// Travel
	ITEM_CAR(0x61);

	private int value;

	Category(int value)
	{
		this.value = value;
	}

	/**
	 * Returns associated integer value of {@link Category}.
	 *
	 * @return integer value
	 */
	public int toValue()
	{
		return value;
	}

	/**
	 * Creates {@link Category} item matching given value.
	 *
	 * @param value value
	 * @return category item
	 */
	public static Category fromValue(int value)
	{
		for (Category cat : Category.values())
		{
			if (cat.toValue() == value)
				return cat;
		}

		return Category.ITEM_DEFAULT;
	}

	/**
	 * Returns string equivalent for given item {@link Category}.
	 *
	 * @param context context
	 * @return category string
	 */
	public String getString(Context context)
	{
		Resources res = context.getResources();

		switch (this)
		{
			case ITEM_CAR:
				return res.getString(R.string.category_car);
			case ITEM_FOOD:
				return res.getString(R.string.category_food);
			case ITEM_GAMING:
				return res.getString(R.string.category_gaming);
			case ITEM_HOUSE:
				return res.getString(R.string.category_house);
			case ITEM_IMPORTANT:
				return res.getString(R.string.category_important);
			case ITEM_PARTY:
				return res.getString(R.string.category_party);
			case ITEM_PHONE:
				return res.getString(R.string.category_phone);
			case ITEM_SCHOOL:
				return res.getString(R.string.category_school);
			case ITEM_SHOPPING:
				return res.getString(R.string.category_shopping);
			case ITEM_SPORT:
				return res.getString(R.string.category_sport);
			case ITEM_WORK:
				return res.getString(R.string.category_work);

			case ITEM_DEFAULT:
			default:
				return res.getString(R.string.category_default);
		}
	}

	/**
	 * Returns drawable equivalent for given item {@link Category}.
	 *
	 * @param context context
	 * @return category drawable
	 */
	public Drawable getDrawable(Context context)
	{
		switch (this)
		{
			case ITEM_CAR:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_car);

			case ITEM_FOOD:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_food);

			case ITEM_GAMING:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_gaming);

			case ITEM_HOUSE:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_house);

			case ITEM_IMPORTANT:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_important);

			case ITEM_PARTY:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_party);

			case ITEM_PHONE:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_phone);

			case ITEM_SCHOOL:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_school);

			case ITEM_SHOPPING:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_shopping);

			case ITEM_SPORT:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_sport);

			case ITEM_WORK:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_work);

			case ITEM_DEFAULT:
			default:
				return ContextCompat.getDrawable(
					context,
					R.drawable.ic_category_default);
		}
	}
}
