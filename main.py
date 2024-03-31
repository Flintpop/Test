import os

from hehe import print_function_d
from update_project import AutoUpdateProgram
import argparse


def print_wrapper(message, print_formatted=True):
    print(message)


if __name__ == "__main__":
    # Parse voir s'il y a force dans les arguments
    project_root_path = os.path.abspath(os.path.join(os.path.dirname(__file__)))
    main_file = os.path.join(project_root_path, 'main.py')
    AutoUpdateProgram(main_file, project_root_path, log=print_wrapper, log_error=print_wrapper,
                      ps1_file_path="update.ps1", force_update=True).update()

    parser = argparse.ArgumentParser()

    parser.add_argument("--force", action="store_true", help="Force the update")
    args = parser.parse_args()

    if args.force:
        print("Forcing the update")
        exit(0)


    print_function_d()


