/*
 * Copyright (C) 2016 Yadieet SA <yadieet@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package thread;

import java.util.function.BooleanSupplier;

/**
 * Created by Yadieet SA on 17/06/16.
 */
final class HelloWorldRunnable implements Runnable //Separation of concerns
{
    private final BooleanSupplier sns;

    HelloWorldRunnable( BooleanSupplier sns )
    {
        this.sns = sns;
    }


    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " : Started.");

        try
        {
            while (!sns.getAsBoolean())
            {
                System.out.println(Thread.currentThread().getName() + " : Hello World !");
                Thread.sleep(333L);
            }
        }
        catch( InterruptedException ignored )
        {
        }

        System.out.println(Thread.currentThread().getName() + " : Exitting..");
    }

}
